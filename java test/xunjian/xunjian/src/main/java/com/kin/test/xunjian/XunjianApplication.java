package com.kin.test.xunjian;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.kin.test.xunjian.pc.systemManager.mapper")
@SpringBootApplication
public class XunjianApplication {

    public static void main(String[] args) {
        SpringApplication.run(XunjianApplication.class, args);
    }

}
