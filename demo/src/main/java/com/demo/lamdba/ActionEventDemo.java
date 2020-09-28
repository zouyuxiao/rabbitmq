package com.demo.lamdba;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Description 使用lambda表达式实现ActionListener
 * @Author zouyuxiao
 * @Date 2020-09-28 16:18
 */

public class ActionEventDemo {
    private JButton button = new JButton();


    public void bindEvent(){
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("你好！" );

            }
        });
    }

    /**
     * 使用Lambda表达式 为button添加ActionListener
     */
    public void bindEventByLambda(){
        button.addActionListener(e -> System.out.println("你好！"));
    }

    public static void main(String[] args) {

    }
}
