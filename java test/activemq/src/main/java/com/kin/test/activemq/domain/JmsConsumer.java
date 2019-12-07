package com.kin.test.activemq.domain;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

/**
 * @program: activemqdemo
 * @description: 消息消费者
 * @author: 黄永健
 * @create: 2019-10-10 15:19
 **/
public class JmsConsumer {

    public static final String ACTIVEMQ_URL="tcp://localhost:61616";
    public static final String QUEUE_NAME="queue01";

    public static void main(String[] args) throws JMSException, IOException {
        //1、创建连接工厂,按照给定的url地址，采用默认用户名和密码
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        //2、通过连接工厂，获得连接connection
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        //3、创建会话session
        //3.1 两个参数：第一个是 事务，第二个是签收
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //4、创建目的地（具体是队列还是主题topic）
        Queue queue = session.createQueue(QUEUE_NAME);
        //5、创建消费者
        MessageConsumer messageConsumer = session.createConsumer(queue);

        /* 第一种方式接收消息
        while (true){
            TextMessage textMessage = (TextMessage) messageConsumer.receive(3000);
            if (textMessage != null){
                System.out.println("消费者接收消息：" +textMessage.getText());
            }else {
                break;
            }
        }
        messageConsumer.close();
        session.close();
        connection.close();*/

        //第二种方法接收消息
        messageConsumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                if (message != null && message instanceof TextMessage){
                    TextMessage textMessage = (TextMessage) message;
                    try {
                        System.out.println("消费者接收消息：" +textMessage.getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        System.in.read();//由于速度太快，还没有接收到消息，下面3条关闭资源的代码就执行了，所以会导致没有消费消息。因此需要加入此行代码。
        messageConsumer.close();
        session.close();
        connection.close();

    }
}
