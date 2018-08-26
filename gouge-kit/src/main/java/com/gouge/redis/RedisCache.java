package com.gouge.redis;

/**
 * 注意：以下实现的方法内部key和field内部都使用字节实现
 *
 * @author xianyongjie
 */
public interface RedisCache<T> {


    Long setnx(final String key, final String value);

    /**
     * 设置过期时间
     *
     * @param key
     * @return
     */
    int expire(String key, int expireSeconds);

    /**
     * 获取key对应的value
     *
     * @param key
     * @return
     */
    Object get(String key);
    
    /**
     * 获取key对应的value
     * @param key
     * @return
     */
    String getCacheString(String key);

    /**
     *  获取hash数据类型key，field对应的value
     *
     * @param key
     * @param field
     * @return
     */
    Object get(String key, String field);

    /**
     * 是否包含key
     *
     * @param key
     * @return
     */
    boolean contains(String key);

    /**
     * hash数据类型
     *
     * @param key
     * @param field
     * @return
     */
    boolean contains(String key, String field);

    /**
     * 查看剩余生存时间,原redis命令ttl
     *
     * @param key
     * @return -1, 如果key没有到期超时,-2, 如果键不存在
     */
    int ttl(String key);

    /**
     * 对key设置缓存数据
     *
     * @param key
     * @param value
     * @param expireSeconds <=0表示永不超时
     */
    void put(String key, Object value, int expireSeconds);

    /**
     * 集合类型设置key对应field的单个值
     *
     * @param key
     * @param field
     * @param value
     * @param expireSeconds <=0表示永不超时（如果field不为空，缓存时间针对field）
     */
    void put(String key, String field, Object value, int expireSeconds);

    /**
     * 移除key
     *
     * @param key
     * @return
     */
    void remove(String key);

    /**
     * 集合类型移除key对应的field
     *
     * @param key
     * @param field
     * @return
     */
    void remove(String key, String field);

    /**
     * 增计数器
     *
     * @param key
     * @param field
     * @param value
     * @param expireSeconds <=0表示永不超时（如果field不为空，缓存时间针对field）
     */
    void incr(String key, String field, int value, int expireSeconds);

    /**
     * 增计数器
     *
     * @param key
     * @param value
     * @param expireSeconds <=0表示永不超时
     */
    void incr(String key, int value, int expireSeconds);
    
    /**
     * redis客户端执行方法，该方法不会抛异常
     *
     * @param callback
     * @return
     */
    Object execute(Callback<T> callback);

    /**
     * redis客户端执行方法
     *
     * @param callback
     * @return
     */
    Object executeThrowExcepton(Callback<T> callback) throws Exception;

    /**
     * @param <T>
     * @author xianyongjie
     */
    interface Callback<T> {
        /**
         * @param jedis
         * @return
         */
        Object process(T jedis) throws Exception;
    }


}
