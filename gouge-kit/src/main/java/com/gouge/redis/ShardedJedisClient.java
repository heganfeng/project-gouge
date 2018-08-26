package com.gouge.redis;

import com.gouge.kit.serialize.SerializeUtil;
import com.gouge.kit.string.StringKit;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import redis.clients.jedis.*;

import java.util.ArrayList;
import java.util.List;

public class ShardedJedisClient implements RedisCache<ShardedJedis> {

    protected final static Logger log = LogManager.getLogger(ShardedJedisClient.class);

    private ShardedJedisPool jedisPool;

    private JedisPoolConfig jedisPoolConfig;

    private int timeout = Protocol.DEFAULT_TIMEOUT;

    private String serverAddress;

    private String password = null;

    public ShardedJedisClient(String serverAddress, JedisPoolConfig jedisPoolConfig,
                              int timeout, String password) {
        this.password = password;
        this.serverAddress = serverAddress;
        this.jedisPoolConfig = jedisPoolConfig;
        this.timeout = timeout;
        init();
    }

    public ShardedJedisClient(String serverAddress, JedisPoolConfig jedisPoolConfig,
                              int timeout) {
        this(serverAddress, null, timeout, null);
    }

    public ShardedJedisClient(String serverAddress, JedisPoolConfig jedisPoolConfig) {
        this(serverAddress, null, Protocol.DEFAULT_TIMEOUT);
    }

    /**
     * 初始化
     */
    private void init() {
        if (StringKit.isNotBlank(serverAddress)) {
            String[] addresses = serverAddress.split(",|;");
            List<JedisShardInfo> shards = new ArrayList<>();
            for (String address : addresses) {
                //log.debug("redisIps="+address);
                String[] ipAndPort = address.split(":");
                String ip = ipAndPort[0];
                String port = ipAndPort[1];

                JedisShardInfo info = new JedisShardInfo(ip, Integer.parseInt(port), timeout);
                if (StringKit.isNotBlank(password)) {
                    info.setPassword(password);
                }

                shards.add(info);
            }

            jedisPool = new ShardedJedisPool(jedisPoolConfig, shards);

        } else {
            throw new RuntimeException("redis的配置IP地址为空，请检查redis.properties配置");
        }
    }

    @Override
    public Object get(String key) {
        key = this.getZipKey(key);
        return this.get(key, null);
    }

    @Override
    public String getCacheString(final String key) {
        Object obj = this.execute(new Callback<ShardedJedis>() {
            @Override
            public Object process(ShardedJedis jedis) throws Exception {
                byte[] rs = jedis.get(key.getBytes());
                if (rs != null && rs.length > 0) {
                    return new String(rs, "UTF-8");
                }
                return null;
            }
        });
        if (obj != null) {
            return String.valueOf(obj);
        }
        return null;
    }

    @Override
    public Object get(final String key, final String field) {
        return this.execute(new Callback<ShardedJedis>() {
            @Override
            public Object process(ShardedJedis jedis) throws Exception {

                byte[] rs = null;
                if (StringKit.isBlank(field)) {
                    rs = jedis.get(key.getBytes());
                } else {
                    rs = jedis.hget(key.getBytes(), field.getBytes());
                }
                if (rs != null) {
                    return SerializeUtil.unserialize(rs);
                }
                return null;
            }
        });
    }


    public Long setnx(final String key, final String value) {
        return (Long) this.execute(jedis -> jedis.setnx(key, value));
    }

    @Override
    public boolean contains(String key) {
        key = this.getZipKey(key);
        return this.contains(key, null);
    }

    @Override
    public boolean contains(final String key, final String field) {
        return (boolean) this.execute(new Callback<ShardedJedis>() {

            @Override
            public Object process(ShardedJedis jedis) throws Exception {

                if (StringKit.isBlank(field)) {
                    return jedis.exists(key.getBytes());
                } else {
                    return jedis.hexists(key.getBytes(), field.getBytes());
                }

            }
        });
    }

    @Override
    public int ttl(final String key) {
        final String zipKey = this.getZipKey(key);
        return (int) this.execute(new Callback<ShardedJedis>() {

            @Override
            public Object process(ShardedJedis jedis) throws Exception {
                return jedis.ttl(zipKey.getBytes()).intValue();
            }
        });
    }

    @Override
    public void put(String key, Object value, int expireSeconds) {
        key = this.getZipKey(key);
        this.put(key, null, value, expireSeconds);
    }

    @Override
    public void put(final String key, final String field, final Object value, final int expireSeconds) {

        this.execute(new Callback<ShardedJedis>() {

            @Override
            public Object process(ShardedJedis jedis) throws Exception {
                if (StringKit.isBlank(field)) {
                    jedis.set(key.getBytes(), SerializeUtil.serialize(value));
                    if (expireSeconds > 0) {
                        jedis.expire(key.getBytes(), expireSeconds);
                    }
                } else {
                    ShardedJedisPipeline pipeline = jedis.pipelined();
                    pipeline.hsetnx(key.getBytes(), field.getBytes(), SerializeUtil.serialize(value));
                    if (expireSeconds > 0) {
                        pipeline.expire(key.getBytes(), expireSeconds);
                    }
                    pipeline.sync();

                }
                return null;
            }
        });


    }

    @Override
    public void remove(String key) {
        key = this.getZipKey(key);
        this.remove(key, null);

    }

    @Override
    public void remove(final String key, final String field) {
        this.execute(new Callback<ShardedJedis>() {

            @Override
            public Object process(ShardedJedis jedis) throws Exception {
                if (StringKit.isBlank(field)) {
                    jedis.del(key.getBytes());
                } else {
                    jedis.hdel(key.getBytes(), field.getBytes());
                }
                return null;
            }
        });

    }

    @Override
    public void incr(final String key, final String field, final int value, final int expireSeconds) {

        this.execute(new Callback<ShardedJedis>() {

            @Override
            public Object process(ShardedJedis jedis) throws Exception {
                if (StringKit.isBlank(field)) {
                    jedis.incrBy(key.getBytes(), value);
                    if (expireSeconds > 0) {
                        jedis.expire(key.getBytes(), expireSeconds);
                    }
                } else {
                    ShardedJedisPipeline pipeline = jedis.pipelined();

                    pipeline.hincrBy(key.getBytes(), field.getBytes(), value);
                    if (expireSeconds > 0) {
                        pipeline.expire(key.getBytes(), expireSeconds);
                    }
                    pipeline.sync();
                }
                return null;
            }
        });

    }

    @Override
    public void incr(String key, int value, int expireSeconds) {
        key = this.getZipKey(key);
        this.incr(key, null, value, expireSeconds);

    }


    @Override
    public Object execute(
            RedisCache.Callback<ShardedJedis> callback) {
        try {
            return executeThrowExcepton(callback);
        } catch (Exception e) {
            log.error("execute", e);
        }
        return null;
    }

    @Override
    public Object executeThrowExcepton(
            RedisCache.Callback<ShardedJedis> callback)
            throws Exception {
        ShardedJedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return callback.process(jedis);
        } catch (Exception e) {
            throw e;
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * 当f值长度大于100时使用md5进行压缩
     *
     * @param key
     * @return
     */
    private String getZipKey(String key) {
        String f = key;
        if (f.length() > 100) {
            return DigestUtils.md5Hex(f);
        } else {
            return f;
        }
    }

    /**
     * 返回到链接池
     *
     * @param jedis
     */
    public void returnResource(ShardedJedis jedis) {
        if (jedis != null) {
            try {
                jedis.close();
            } catch (Exception e) {
                log.error("returnResource", e);
            }

        }
    }

    @Override
    public int expire(final String key, final int expireSeconds) {
        this.execute(new Callback<ShardedJedis>() {

            @Override
            public Object process(ShardedJedis jedis) throws Exception {
                if (expireSeconds > 0) {
                    jedis.expire(key.getBytes(), expireSeconds);
                }
                return expireSeconds;
            }
        });
        return -1;
    }

}
