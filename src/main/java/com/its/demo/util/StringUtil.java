package com.its.demo.util;

/**
 * 字符串工具类
 *
 * @author 杨金刚
 * @date 2019/2/11 9:15
 */
public class StringUtil {
    /**
     * 判断字符串数组中是否包含某字符串
     *
     * @param arrString 字符串数组
     * @param searchString 目标字符串
     * @return true-包含，false-不包含
     */
    public static boolean contains(String[] arrString, String searchString) {
        for (String s : arrString) {
            if(searchString.contains(s)) {
                return true;
            }
        }

        return false;
    }
}
