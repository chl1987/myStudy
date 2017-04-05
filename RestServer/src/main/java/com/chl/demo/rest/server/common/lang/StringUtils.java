package com.chl.demo.rest.server.common.lang;

/**
 * 字符串工具
 * Created by caodongdong on 2017-03-30.
 */
public class StringUtils {
    public static boolean isEmpty(String str) {
        return ((str == null) || (str.trim().length() == 0));
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * 只要有一个是空，就返回true
     */
    public static boolean isEmpty(String... strs) {
        for (String str : strs) {
            if (isEmpty(str)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 只要有一个是空，就返回true
     */
    public static boolean isEmpty(Object... strs) {
        for (Object str : strs) {
            if (isEmpty(str)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 只要有一个是空，就返回true
     */
    public static boolean isEmpty(Object str) {
        if (str == null) {
            return true;
        }
        return false;
    }

    /**
     * 全部都不为空才返回true
     */
    public static boolean isNotEmpty(String... strs) {
        return !isEmpty(strs);
    }
}
