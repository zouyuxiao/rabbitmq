package com.mq.prodive.hello;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Description 生产者消息
 * @Author zouyuxiao
 * @Date 2020-09-18 09:40
 */

public class Provider {

    @Test
    public void testSendMessage() throws IOException, TimeoutException {
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
        * 通道绑定对应消息队列
        * 参数1：队列名称，如果不存在自动创建
        * 参数2：用来定义队列特性是否要持久 true 持久化队列 false 不持久化
        * 参数3：exclusive 是否独占队列 true 独占队列 false 不独占
        * 参数4：autoDelete 是否消费完后自动删除队列 true 自动删除 false 不自动删除
        * 参数5：额外附加参数
        *
        * */
        channel.queueDeclare("hello",false,false,false,null);

        /*
        * 发布消息
        * 参数1：交换机名称
        * 参数2：队列名称
        * 参数3：传递消息额外设置
        * 参数4：消息的具体内容
        *
        *
        * */
        channel.basicPublish("", "hello", null, "你好 mq".getBytes());

        channel.close();
        connection.close();
    }
}
