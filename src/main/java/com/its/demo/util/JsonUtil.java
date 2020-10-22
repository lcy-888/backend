package com.its.demo.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * JSON工具类
 *
 * @author 杨金刚
 * @date 2019/2/20 13:09
 */
public class JsonUtil {

    static ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
        // 属性为NULL则不参与序列化
        //objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        // 属性为 空（""）或者为NULL都不序列化
        //objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        // 允许出现特殊字符和转义符
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER, true);
        // 允许出现单引号
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS, true);
    }

    /**
     * Json串转对象（泛型）
     *
     * @param content Json串
     * @param valueType 类型
     * @param <T>
     * @return
     */
    public static <T> T readValue(String content, Class<T> valueType) {

        try {
            //字符串转Json对象
            return objectMapper.readValue(content, valueType);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static <T> T readValue(String content, TypeReference typeReference) {

        try {
            //字符串转Json对象
            return (T) objectMapper.readValue(content, typeReference);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 对象转Json串
     *
     * @param object
     * @return
     */
    public static String toJSon(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            return null;
        }
    }
}


