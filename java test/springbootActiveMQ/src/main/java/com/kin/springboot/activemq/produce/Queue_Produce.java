package com.kin.springboot.activemq.produce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.jms.Queue;
import java.util.UUID;

/**
 * @program: springbootActiveMQ
 * @description: 队列生产者
 * @author: 黄永健
 * @create: 2019-10-17 15:47
 **/
@Service
public class Queue_Produce {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private Queue queue;
    public void produceMsg(){
        jmsMessagingTemplate.convertAndSend(queue,"*****"+ UUID.randomUUID().toString().substring(0,6));
    }

    //间隔时间3秒钟定时投递消息
    @Scheduled(fixedDelay = 3000)
    public void produceMsgScheduled(){
        jmsMessagingTemplate.convertAndSend(queue,"*****Scheduled"+ UUID.randomUUID().toString().substring(0,6));
        System.out.println("*******produceMsgScheduled send ok");
    }
}
