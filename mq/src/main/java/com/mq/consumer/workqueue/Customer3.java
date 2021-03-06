package com.mq.consumer.workqueue;

import com.mq.util.RabbitMQUtil;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @Description 能者多劳
 * @Author zouyuxiao
 * @Date 2020-09-18 13:57
 */

public class Customer3 {
    public static void main(String[] args) throws IOException {
        // 获取连接对象
        Connection connection = RabbitMQUtil.getConnection();
        // 获取连接通道对象
        Channel channel = connection.createChannel();
        // 通过通道声明队列
        channel.queueDeclare("work", true, false, false, null);
        channel.basicQos(1);
        channel.basicConsume("work", false, new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者3---->"+new String(body));
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        });
    }
}
