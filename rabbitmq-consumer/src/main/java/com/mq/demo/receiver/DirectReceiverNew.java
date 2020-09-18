package com.mq.demo.receiver;

/*
*
 * @Description
 * @Author zouyuxiao
 * @Date 2020-08-26 09:00
*/


import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = "TestDirectQueue")//监听的队列名称 TestDirectQueue
public class DirectReceiverNew {

    @RabbitHandler
    public void process(Map testMessage) {
        System.out.println("第二个-DirectReceiver消费者收到消息  : " + testMessage.toString());
    }

}
