package com.demo.lamdba;

import java.util.Arrays;
import java.util.List;

/**
 * @Description Lambda 表达式
 * @Author zouyuxiao
 * @Date 2020-09-28 15:32
 *
 * 语法
 * lambda 表达式的语法格式如下：
 *
 * (parameters) -> expression
 * 或
 * (parameters) ->{ statements; }
 * 以下是lambda表达式的重要特征:
 *
 * 可选类型声明：不需要声明参数类型，编译器可以统一识别参数值。
 * 可选的参数圆括号：一个参数无需定义圆括号，但多个参数需要定义圆括号。
 * 可选的大括号：如果主体包含了一个语句，就不需要使用大括号。
 * 可选的返回关键字：如果主体只有一个表达式返回值则编译器会自动返回值，大括号需要指定明表达式返回了一个数值。
 */

public class demo01 {
    public static void main(String[] args) {

        List<Integer> num = Arrays.asList(1,2,3,4,5);
        for (int element : num){
            System.out.println(element);
        }

        System.out.println("---------------Lambda表达式----------------------");
        num.forEach(x -> System.out.println(x));

        num.forEach(x -> {
            System.out.println(x);
            System.out.println("------->");
        });

        /*如果只需要调用单个函数对列表元素进行处理，那么可以使用更加简洁的 方法引用 代替 Lambda 表达式*/
        num.forEach(System.out::println);
    }
}
