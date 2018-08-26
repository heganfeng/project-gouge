package com.gouge.kit.serialize;

import org.nustaq.serialization.FSTConfiguration;


/**
 * FST序列化工具类
 *
 * @author xianyongjie
 */
public class SerializeUtil {


    static FSTConfiguration CONFIG = FSTConfiguration.createDefaultConfiguration();

    /**
     * 序列化
     *
     * @param object
     * @return
     * @throws Exception
     */
    public static byte[] serialize(Object object) throws Exception {
        return CONFIG.asByteArray(object);
    }

    /**
     * 反序列化
     *
     * @param bytes
     * @return
     * @throws Exception
     */
    public static Object unserialize(byte[] bytes) throws Exception {
        return CONFIG.asObject(bytes);
    }
}
