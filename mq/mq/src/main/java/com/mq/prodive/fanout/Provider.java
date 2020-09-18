package com.mq.prodive.fanout;

import com.mq.util.RabbitMQUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

/**
 * @Description fanout 模型
 * @Author zouyuxiao
 * @Date 2020-09-18 11:44
 */

public class Provider {

    public static void main(String[] args) throws IOException {
        // 获取连接对象
        Connection connection = RabbitMQUtil.getConnection();
        // 获取连接通道对象
        Channel channel = connection.createChannel();
        // 将通道声明指定交换机 // 参数1：交换机名称 参数2：交换机类型 fanout 广播类型
        channel.exchangeDeclare("logs", "fanout");

        // 发送消息
        channel.basicPublish("logs", "", null, "fanout 类型消息".getBytes());

        // 释放资源
        RabbitMQUtil.closeConnectionAndChanel(channel, connection);
    }
}
