package com.kin.springboot.activemq.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * @program: springbootActiveMQ
 * @description: 主题消息消费者
 * @author: 黄永健
 * @create: 2019-10-17 17:18
 **/
@Service
public class Topic_Consumer {

    @JmsListener(destination = "${myTopic}")
    public void receive(TextMessage textMessage)throws JMSException{
        try {
            System.out.println("消费者收到订阅的主题：" + textMessage.getText());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
