package com.kin.test.activemq.domain;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

/**
 * @program: activemqdemo
 * @description: 一对多消息消费者topic
 * @author: 黄永健
 * @create: 2019-10-10 16:23
 **/
public class JmsConsumer_Topic {
    public static final String ACTIVEMQ_URL="tcp://localhost:61616";
    public static final String TOPIC_NAME="topic-kin";

    public static void main(String[] args) throws JMSException, IOException {
        System.out.println("z3");
        //1、创建连接工厂,按照给定的url地址，采用默认用户名和密码
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        //2、通过连接工厂，获得连接connection
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.setClientID("z3");
        //3、创建会话session
        //3.1 两个参数：第一个是 事务，第二个是签收
        Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
        //4、创建目的地（具体是队列还是主题topic）
        Topic topic = session.createTopic(TOPIC_NAME);
        TopicSubscriber topicSubscriber = session.createDurableSubscriber(topic,"remark...");
        connection.start();
        Message message = topicSubscriber.receive();
        while (null != message){
            TextMessage textMessage = (TextMessage) message;
            System.out.println("******收到的持久化topic"+message);
            //手动签收
            //Session.CLIENT_ACKNOWLEDGE
            //textMessage.acknowledge();
            message=topicSubscriber.receive(1000L);
        }

       /*
              //5、创建消费者
        MessageConsumer messageConsumer = session.createConsumer(topic);//lombok表达式写法
        messageConsumer.setMessageListener((message) -> {
                    if (message != null && message instanceof TextMessage) {
                        TextMessage textMessage = (TextMessage) message;
                        try {
                            System.out.println("消费者接收消息：" + textMessage.getText());
                        } catch (JMSException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
          System.in.read();//由于速度太快，还没有接收到消息，下面3条关闭资源的代码就执行了，所以会导致没有消费消息。因此需要加入此行代码。
        messageConsumer.close();
        */
       //消费者如果开启了事务必须commit，否则消息消费之后一直可以重复消费同一条消息
        session.commit();
        session.close();
        connection.close();

    }
}
