package com.mq.prodive.direct;


import com.mq.util.RabbitMQUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

/**
 * @Description direct模型
 * @Author zouyuxiao
 * @Date 2020-09-18 11:18
 */

public class Provider {
    public static void main(String[] args) throws IOException {
        // 获取连接对象
        Connection connection = RabbitMQUtil.getConnection();
        // 获取连接通道对象
        Channel channel = connection.createChannel();
        // 通过通道声明交换机 参数1：交换机名称 参数2：direct 路由模式
        channel.exchangeDeclare("logs_direct", "direct");
        // 发送消息
        String routingkey = "error";
        channel.basicPublish("logs_direct", routingkey, null, ("这是direct模型发布基于routingkey").getBytes());
        // 关闭资源
        RabbitMQUtil.closeConnectionAndChanel(channel,connection);
    }

}
