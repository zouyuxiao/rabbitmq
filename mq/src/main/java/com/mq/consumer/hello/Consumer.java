package com.mq.consumer.hello;

import com.rabbitmq.client.*;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Description
 * @Author zouyuxiao
 * @Date 2020-09-18 10:23
 */

public class Consumer {

    public static void main(String[] args) throws IOException, TimeoutException {
        Consumer consumer = new Consumer();
        consumer.test();
    }

    @Test
    public void testConsumerMessage() throws IOException, TimeoutException {
       test(); // 无法一直监听
    }

    public void test() throws IOException, TimeoutException {
        // 创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        // 设置连接主机
        connectionFactory.setHost("localhost");
        // 设置端口
        connectionFactory.setPort(5672);
        // 设置连接虚拟主机
        connectionFactory.setVirtualHost("root");
        // 设置用户名和密码
        connectionFactory.setUsername("root");
        connectionFactory.setPassword("root");

        // 获取连接对象
        Connection connection = connectionFactory.newConnection();

        // 获取连接通道
        Channel channel = connection.createChannel();

        /*
         * 消费信息
         * 参数1：消息哪个队列的消息 队列名称
         * 参数2：开始消息的自动确认机制
         * 参数3：消费时回调接口
         *
         * */
        channel.basicConsume("hello", true, new DefaultConsumer(channel){
            @Override // 最后一个参数取出队列信息
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("=================="+new String(body));
            }
        });
    }
}


