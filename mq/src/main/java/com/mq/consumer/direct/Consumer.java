package com.mq.consumer.direct;

import com.mq.util.RabbitMQUtil;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @Description
 * @Author zouyuxiao
 * @Date 2020-09-18 11:29
 */

public class Consumer {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtil.getConnection();
        Channel channel = connection.createChannel();

        // 声明交换机 以及交换机类型 direct
        channel.exchangeDeclare("logs_direct", "direct");

        // 创建临时队列
        String queue = channel.queueDeclare().getQueue();

        // 临时队列和交换机绑定
        channel.queueBind(queue, "logs_direct", "info");
        channel.queueBind(queue, "logs_direct", "error");
        channel.queueBind(queue, "logs_direct", "warning");

        // 消费消息
        channel.basicConsume(queue, true, new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者1--->"+new String(body));
            }
        });

    }
}
