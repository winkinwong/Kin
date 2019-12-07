package com.kin.springboot.activemq.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

/**
 * @program: springbootActiveMQ
 * @description: 配置类
 * @author: 黄永健
 * @create: 2019-10-17 15:46
 **/
@Component
@EnableJms //开启jms适配注解
public class ConfigBean {

    //从yml配置文件注入kv
    @Value("${myqueue}")
    private String myQueue;

    @Bean //<bean id="" class="">
    public Queue queue(){
        return new ActiveMQQueue(myQueue);
    }

}
