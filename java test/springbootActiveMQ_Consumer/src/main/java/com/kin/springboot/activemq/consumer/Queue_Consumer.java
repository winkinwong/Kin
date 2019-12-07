package com.kin.springboot.activemq.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import javax.jms.TextMessage;

/**
 * @program: springbootActiveMQ
 * @description: 消息队列消费者
 * @author: 黄永健
 * @create: 2019-10-17 16:56
 **/
@Service
public class Queue_Consumer {

    @JmsListener(destination = "${myqueue}")//监听接收消息
    public void receive(TextMessage textMessage)throws Exception{
        System.out.println("*****消费者收到的消息:"+textMessage.getText());
    }

}
