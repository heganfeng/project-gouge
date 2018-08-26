package com.gouge.redis;

/**
 * Created by grandfen on 17/7/20.
 */
public class RedisUtil {

    public final static int DEFAULT_EXPIRE = 60*5; //默认缓存5分钟

    public final static int APPLICATION_EXPIRE = 60*60; //缓存一个小时

    public final static int LOGIN_EXPIRE = 60*15; //缓存15分钟

    public final static int LOGIN_SWING_EXPIRE = 60*60*2; //缓存2个小时分钟

    public final static String PREFIX = "API";
}
