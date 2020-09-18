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


        // ��ȡ���Ӷ���
        Connection connection = connectionFactory.newConnection();
        // ��ȡ����ͨ��
        Channel channel = connection.createChannel();
        /**
         * name:��������
         * durable���Ƿ�־û�, ���е�����Ĭ���Ǵ�ŵ��ڴ��еģ����rabbitmq�����ᶪʧ��
         * ���������֮�󻹴��ھ�Ҫʹ���г־û������浽Erlang�Դ���Mnesia���ݿ��У���rabbitmq����֮����ȡ�����ݿ�
         *
         * autoDelete���Ƿ��Զ�ɾ�����У������һ�������߶Ͽ�����֮������Ƿ��Զ���ɾ����
         * ����ͨ��RabbitMQ Management���鿴ĳ�����е���������������consumers = 0ʱ���оͻ��Զ�ɾ��
         *
         * exclusive���Ƿ�����ģ����������ã�
         * һ�������ӹر�ʱconnection.close()�ö����Ƿ���Զ�ɾ����
         * �����ö����Ƿ���˽�е�private�������������ģ�����ʹ�����������߶�����ͬһ�����У�
         * û���κ����⣬���������ģ���Ե�ǰ���м���������ͨ��channel�ǲ��ܷ��ʵģ�
         * ���ǿ�Ʒ��ʻᱨ�쳣��com.rabbitmq.client.ShutdownSignalException:
         * channel error; protocol method: #method<channel.close>
         *     (reply-code=405, reply-text=RESOURCE_LOCKED - cannot obtain exclusive access to locked queue 'queue_name' in vhost '/',
         *     class-id=50, method-id=20)һ�����true�Ļ�����һ������ֻ����һ�������������ѵĳ���
         *
         * noWait:�Ƿ�ȴ�����������
         *
         * args����ز�����Ŀǰһ��Ϊnil
         */
        channel.queueDeclare("helloword",false,false,false,null);

        /**
         * exchange:Ҫ����Ϣ���͵���Exchange(������)
         * routingKey:·��Key
         * mandatory:true ���mandatory��Ǳ�����
         * immediate: true ���immediate��Ǳ����ã�ע�⣺RabbitMQ����˲�֧�ִ˱��
         * props:������һЩ���ԣ��磺{@link MessageProperties.PERSISTENT_TEXT_PLAIN}
         * body:��Ϣ����
         **/
        channel.basicPublish("","helloword",null,"���".getBytes());

        channel.close();
        connection.close();

    }


}
