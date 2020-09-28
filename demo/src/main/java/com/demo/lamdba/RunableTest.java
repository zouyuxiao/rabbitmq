package com.demo.lamdba;

/**
 * @Description 使用lambda表达式替换Runnable匿名内部类
 * @Author zouyuxiao
 * @Date 2020-09-28 16:03
 */

public class RunableTest {
    /**
     * 普通的Runnable
     */
    public static void runSomeThing(){

        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                System.out.println("I am running");
            }
        };
        new Thread(runnable).start();
    }

    /**
     * 使用lambda后的
     */
    public static void runSomeThingByLambda(){
        new Thread(() -> System.out.println("I am running")).start();
    }

    public static void main(String[] args) {
        runSomeThing();
        runSomeThingByLambda();
    }
}
