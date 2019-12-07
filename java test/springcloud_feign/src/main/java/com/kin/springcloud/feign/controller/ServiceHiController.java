package com.kin.springcloud.feign.controller;

import com.kin.springcloud.feign.service.SchedualServcieHi;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

/**
 * @program: springcloud_feign
 * @description: 测试调用service-hi服务
 * @author: 黄永健
 * @create: 2019-10-21 10:02
 **/
@RestController
@RequestMapping("/feign")
public class ServiceHiController {
    @Resource
    SchedualServcieHi schedualServcieHi;

    @GetMapping("/hi")
    public String sayHiFromClientOne(@NotNull String name){
        return schedualServcieHi.sayHiFromClientOne(name);
    }
}
