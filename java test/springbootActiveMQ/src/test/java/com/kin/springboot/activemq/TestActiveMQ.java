package com.kin.springboot.activemq;

import com.kin.springboot.activemq.produce.Queue_Produce;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

/**
 * @program: springbootActiveMQ
 * @description: activemq单元测试类
 * @author: 黄永健
 * @create: 2019-10-17 16:11
 **/
@SpringBootTest(classes = App.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestActiveMQ {
    @Resource
    private Queue_Produce queue_produce;

    @Test
    public void testSend()throws Exception{
        queue_produce.produceMsg();
    }
}
