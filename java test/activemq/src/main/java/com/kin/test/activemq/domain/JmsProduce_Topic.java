package com.kin.test.activemq.domain;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @program: activemqdemo
 * @description: 一对多消息生产者topic
 * @author: 黄永健
 * @create: 2019-10-10 16:20
 **/
public class JmsProduce_Topic {

    public static final String ACTIVEMQ_URL="tcp://localhost:61616";
    public static final String TOPIC_NAME="topic-kin";

    public static void main(String[] args) throws JMSException {

        //1、创建连接工厂,按照给定的url地址，采用默认用户名和密码
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        //2、通过连接工厂，获得连接connection
        Connection connection = activeMQConnectionFactory.createConnection();

        //3、创建会话session
        //3.1 两个参数：第一个是 事务，第二个是签收
        Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
        //4、创建目的地（具体是队列还是主题topic）
        Topic topic = session.createTopic(TOPIC_NAME);
        //5、创建消息的生产者
        MessageProducer messageProducer = session.createProducer(topic);
        //6、通过使用MessageProducer生产3条消息发送到MQ的队列里面
        messageProducer.setDeliveryMode(DeliveryMode.PERSISTENT);
        connection.start();
        for(int i = 4; i<=6;i++){
            //7、创建消息
            TextMessage textMessage = session.createTextMessage("topic-kin_msg -- "+i);//理解为一个字符串
            //8、通过MessageProducer发送给MQ
            messageProducer.send(textMessage);
        }
        //9、关闭资源
        messageProducer.close();
        session.commit();
        session.close();
        connection.close();

        System.out.println("topic-kin********消息发布到mq完成");
    }
}
