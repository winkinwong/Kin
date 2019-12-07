package com.kin.test.springboot.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: springboot0918
 * @description: 计划定时任务测试类
 * @author: 黄永健
 * @create: 2019-09-26 17:24
 **/
@Service
public class Task {
    private static final SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

/*    //初始延迟1秒，每隔2秒
    @Scheduled(fixedRateString = "2000",initialDelay = 1000)
    public void testFixedRate(){
        System.out.println("fixedRateString,当前时间：" +format.format(new Date()));
    }

    //每次执行完延迟2秒
    @Scheduled(fixedDelayString= "2000")
    public void testFixedDelay(){
        System.out.println("fixedDelayString,当前时间：" +format.format(new Date()));
    }*/

    //每隔5秒执行一次

    @Scheduled(cron="0/5 * * * * ?")
    public void testCron(){
        System.out.println("cron,当前时间：" +format.format(new Date()));
    }

}
