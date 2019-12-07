package com.kin.springcloud.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDiscoveryClient //通过@EnableDiscoveryClient向服务中心注册；
@EnableFeignClients
public class FeignApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(FeignApplication.class,args);
    }
}
