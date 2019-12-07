package com.kin.springcloud.feign.service;

import com.kin.springcloud.feign.service.imp.SchedualServiceHiHystric;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/*
    @ FeignClient（“服务名”），来指定调用哪个服务。比如在代码中调用了service-hi服务的“/hi”接口
 */
@FeignClient(value = "service-hi",fallback = SchedualServiceHiHystric.class)
public interface SchedualServcieHi {
    //@RequestMapping(value = "/hi",method = RequestMethod.GET) //标准写法
    @GetMapping("/hi") //这里的路由指的是调用目标服务中目标方法的路由，它们必须互相一致
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
