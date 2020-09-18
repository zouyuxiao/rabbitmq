package com.mq;

//import com.rabbitmq.client.AMQP;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@SpringBootTest
class ProviderTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testSendMessage() throws IOException, TimeoutException {

        /**
         * spring:
         *   application:
         *     name: rabbitmq-provider
         *   rabbitmq:
         *     host: 127.0.0.1
         *     port: 5672
         *     username: root
         *     password: root
         *     virtual-host: /
         *     publisher-confirm-type: correlated
         *     publisher-returns: true
         */
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setPort(15672);
        connectionFactory.setVirtualHost("root");
        connectionFactory.setUsername("root");
        connectionFactory.setPassword("root");


        // 获取连接对象
        Connection connection = connectionFactory.newConnection();
        // 获取连接通道
        Channel channel = connection.createChannel();
        /**
         * name:队列名字
         * durable：是否持久化, 队列的声明默认是存放到内存中的，如果rabbitmq重启会丢失，
         * 如果想重启之后还存在就要使队列持久化，保存到Erlang自带的Mnesia数据库中，当rabbitmq重启之后会读取该数据库
         *
         * autoDelete：是否自动删除队列，当最后一个消费者断开连接之后队列是否自动被删除，
         * 可以通过RabbitMQ Management，查看某个队列的消费者数量，当consumers = 0时队列就会自动删除
         *
         * exclusive：是否排外的，有两个作用，
         * 一：当连接关闭时connection.close()该队列是否会自动删除；
         * 二：该队列是否是私有的private，如果不是排外的，可以使用两个消费者都访问同一个队列，
         * 没有任何问题，如果是排外的，会对当前队列加锁，其他通道channel是不能访问的，
         * 如果强制访问会报异常：com.rabbitmq.client.ShutdownSignalException:
         * channel error; protocol method: #method<channel.close>
         *     (reply-code=405, reply-text=RESOURCE_LOCKED - cannot obtain exclusive access to locked queue 'queue_name' in vhost '/',
         *     class-id=50, method-id=20)一般等于true的话用于一个队列只能有一个消费者来消费的场景
         *
         * noWait:是否等待服务器返回
         *
         * args：相关参数，目前一般为nil
         */
        channel.queueDeclare("helloword",false,false,false,null);

        /**
         * exchange:要将消息发送到的Exchange(交换器)
         * routingKey:路由Key
         * mandatory:true 如果mandatory标记被设置
         * immediate: true 如果immediate标记被设置，注意：RabbitMQ服务端不支持此标记
         * props:其它的一些属性，如：{@link MessageProperties.PERSISTENT_TEXT_PLAIN}
         * body:消息内容
         **/
        channel.basicPublish("","helloword",null,"你好".getBytes());

        channel.close();
        connection.close();

    }


}
