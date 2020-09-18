package com.mq.consumer.workqueue;

import com.mq.util.RabbitMQUtil;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @Description 能者多劳
 * @Author zouyuxiao
 * @Date 2020-09-18 13:57
 */

public class Customer {
    public static void main(String[] args) throws IOException {
        // 获取连接对象
        Connection connection = RabbitMQUtil.getConnection();
        // 获取连接通道对象
        Channel channel = connection.createChannel();
        // 每次只能确认一条消息
        channel.basicQos(1);
        // 通过通道声明队列
        channel.queueDeclare("work", true, false, false, null);
        channel.basicConsume("work", false, new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("消费者1---->"+new String(body));
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        });
    }
}
