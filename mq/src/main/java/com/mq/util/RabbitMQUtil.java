package com.mq.util;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Description
 * @Author zouyuxiao
 * @Date 2020-09-18 11:05
 */

public class RabbitMQUtil {
    private  static ConnectionFactory connectionFactory;

    static {
        // 重量级资源 类加载值只执行一次
        connectionFactory = new ConnectionFactory();
        // 设置连接主机
        connectionFactory.setHost("localhost");
        // 设置端口
        connectionFactory.setPort(5672);
        // 设置连接虚拟主机
        connectionFactory.setVirtualHost("root");
        // 设置用户名和密码
        connectionFactory.setUsername("root");
        connectionFactory.setPassword("root");
    }

    // 定义停供连接对象方法
    public static Connection getConnection() throws IOException {
        try {
            return connectionFactory.newConnection();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 关闭通道和连接方法
    public static void closeConnectionAndChanel(Channel channel,Connection connection) throws IOException {
        try {
            if (channel != null) channel.close();
            if (connection != null) connection.close();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
