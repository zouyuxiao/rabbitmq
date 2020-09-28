package com.commom.util;

/**
 * @Description 工具类
 * @Author zouyuxiao
 * @Date 2020-09-28 14:22
 */

public class MyUtil {

    /**
     * 判断数据类型
     * @param obj  判断值
     * @return 数据类型
     */
    private static String getType(Object obj) {
        return obj.getClass().toString();
    }
}
