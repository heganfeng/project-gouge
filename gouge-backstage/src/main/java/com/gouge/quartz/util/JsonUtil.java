package com.gouge.quartz.util;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.introspect.AnnotatedClass;
import org.codehaus.jackson.map.introspect.JacksonAnnotationIntrospector;
import org.codehaus.jackson.map.ser.FilterProvider;
import org.codehaus.jackson.map.ser.impl.SimpleBeanPropertyFilter;
import org.codehaus.jackson.map.ser.impl.SimpleFilterProvider;
import org.codehaus.jackson.type.TypeReference;

/**
 * JSON 工具类
 *
 * @author xianyongjie
 */
public class JsonUtil {

    private static JsonFactory jsonFactory = new JsonFactory();

    private static ObjectMapper mapper = null;

    static {
        jsonFactory.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        jsonFactory.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES,
                true);
        mapper = new ObjectMapper(jsonFactory);

        mapper.configure(
                DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY,
                true);
        mapper.configure(
                DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }


    /**
     * 将json转成java bean
     *
     * @param <T>   -- 多态类型
     * @param json  -- json字符串
     * @param clazz -- java bean类型(Class)
     * @return -- java bean对象
     */
    public static <T> T toBean(String json, Class<T> clazz) {

        if (StringUtils.isBlank(json)) {
            return null;
        }
        T rtv = null;
        try {
            rtv = mapper.readValue(json, clazz);
        } catch (Exception ex) {
            throw new IllegalArgumentException("json字符串转成java bean异常", ex);
        }
        return rtv;
    }

    /**
     * JSON串转换为Java泛型对象（其中如果要转化为的是内部类，该内部类必须是static的，否则会出现异常）
     *
     * @param json JSON字符串
     * @param tr   例如: new TypeReference<List<FamousUser> >(){}
     * @return
     */
    public static <T> T toBean(String json, TypeReference<T> tr) {

        if (StringUtils.isBlank(json)) {
            return null;
        }
        T rtv = null;
        try {
            rtv = mapper.readValue(json, tr);
        } catch (Exception ex) {
            throw new IllegalArgumentException("json将json字符串转化成对象出错", ex);
        }
        return rtv;
    }

    /**
     * 将java bean转成json
     *
     * @param bean -- java bean
     * @return -- json 字符串
     */
    public static String toJson(Object bean) {

        if (bean == null) {
            return null;
        }
        String rtv = null;
        try {
            rtv = mapper.writeValueAsString(bean);
        } catch (Exception ex) {
            throw new IllegalArgumentException("java bean转成json字符串异常", ex);
        }
        return rtv;
    }

    /**
     * 将java bean转成json
     *
     * @param obj
     * @param filterFields 需要排除的属性
     * @return
     */
    public static String toJsonWithSerializeAllExcept(Object obj,
                                                      String... filterFields) {
        if (obj == null) {
            return null;
        }
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
            mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
            mapper.configure(
                    DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY,
                    true);
            mapper.configure(
                    DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.setSerializationConfig(mapper.getSerializationConfig()
                    .withSerializationInclusion(
                            JsonSerialize.Inclusion.NON_NULL));
            FilterProvider filters = new SimpleFilterProvider().addFilter(obj
                    .getClass().getName(), SimpleBeanPropertyFilter
                    .serializeAllExcept(filterFields)).setFailOnUnknownId(false);
            mapper.setFilters(filters);
            mapper.setAnnotationIntrospector(new JacksonAnnotationIntrospector() {
                @Override
                public Object findFilterId(AnnotatedClass ac) {
                    return ac.getName();
                }
            });
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new IllegalArgumentException("java bean转成json字符串异常", e);
        }
    }

    /**
     * 将java bean转成json
     *
     * @param obj
     * @param filterFields 需要留下的属性
     * @return
     */
    public static String toJsonWithFilterOutAllExcept(Object obj,
                                                      String... filterFields) {
        if (obj == null) {
            return null;
        }
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
            mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
            mapper.configure(
                    DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY,
                    true);
            mapper.configure(
                    DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.setSerializationConfig(mapper.getSerializationConfig()
                    .withSerializationInclusion(
                            JsonSerialize.Inclusion.NON_NULL));
            FilterProvider filters = new SimpleFilterProvider().addFilter(obj
                    .getClass().getName(), SimpleBeanPropertyFilter
                    .filterOutAllExcept(filterFields)).setFailOnUnknownId(false);
            mapper.setFilters(filters);
            mapper.setAnnotationIntrospector(new JacksonAnnotationIntrospector() {
                @Override
                public Object findFilterId(AnnotatedClass ac) {
                    return ac.getName();
                }
            });
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new IllegalArgumentException("java bean转成json字符串异常", e);
        }
    }

}
