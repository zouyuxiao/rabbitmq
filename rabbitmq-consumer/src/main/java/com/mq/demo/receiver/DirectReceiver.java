package com.mq.demo.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/*
*
 * @Description
 * @Author zouyuxiao
 * @Date 2020-08-26 09:00
*/



@Component
public class DirectReceiver {

    @RabbitListener(queues = "TestDirectQueue")//监听的队列名称 TestDirectQueue
    public void process(Map testMessage) {
        System.out.println("DirectReceiver消费者收到消息  : " + testMessage.toString());
    }


}
