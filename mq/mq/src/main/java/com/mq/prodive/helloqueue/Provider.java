package com.mq.prodive.helloqueue;

import com.mq.util.RabbitMQUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

/**
 * @Description 平均消费
 * @Author zouyuxiao
 * @Date 2020-09-18 13:50
 */

public class Provider {
    public static void main(String[] args) throws IOException {
        // 获取连接对象
        Connection connection = RabbitMQUtil.getConnection();
        // 获取连接通道对象
        Channel channel = connection.createChannel();
        // 通过通道声明队列
        channel.queueDeclare("work", true, false, false, null);

        for (int i = 1; i <= 10; i++){
            // 生产消息
            channel.basicPublish("", "work", null, (i + "----你好工作队列---").getBytes());
        }
        // 关闭资源
        RabbitMQUtil.closeConnectionAndChanel(channel, connection);
    }
}
