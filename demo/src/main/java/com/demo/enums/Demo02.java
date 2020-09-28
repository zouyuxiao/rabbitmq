package com.demo.enums;

/**
 * @Description
 * @Author zouyuxiao
 * @Date 2020-09-28 13:59
 */

public class Demo02 {
    public static void main(String[] args) {
        System.out.println("------------------->");
        Integer code = 200;

        System.out.println(getType(code));
        System.out.println(getType(Demo01.ERROR.getCode()));

        if (Demo01.ERROR.getCode().equals(code)){
            System.out.println("error-->"+Demo01.ERROR.getMsg());
        }else if (Demo01.SUCCESS.getCode().equals(code)){
            System.out.println("success-->"+Demo01.SUCCESS.getMsg());
        }else {
            System.out.println("other");
        }
        System.out.println("<-------------------");
    }

    private static String getType(Object a) {
        return a.getClass().toString();
    }

}
