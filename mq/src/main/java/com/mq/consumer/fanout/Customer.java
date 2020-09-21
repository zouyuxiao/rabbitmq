package com.mq.consumer.fanout;

import com.mq.util.RabbitMQUtil;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @Description
 * @Author zouyuxiao
 * @Date 2020-09-18 13:38
 */

public class Customer {
    public static void main(String[] args) throws IOException {
        // 获取连接对象
        Connection connection = RabbitMQUtil.getConnection();
        // 获取连接通道对象
        Channel channel = connection.createChannel();
        // 将通道声明指定交换机 // 参数1：交换机名称 参数2：交换机类型 fanout 广播类型
        channel.exchangeDeclare("logs", "fanout");

        // 临时队列
        String queueName = channel.queueDeclare().getQueue();

        //绑定交换机和队列
        channel.queueBind(queueName, "logs", "");

        // 消费消息
        channel.basicConsume(queueName, true, new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者1-->"+new String(body));
            }
        });

    }
}
