package com.kin.springcloud.feign.service.imp;

import com.kin.springcloud.feign.service.SchedualServcieHi;
import org.springframework.stereotype.Component;

/**
 * @program: springcloud_feign
 * @description: 断路由处理的实现类
 * @author: 黄永健
 * @create: 2019-10-21 10:57
 **/
@Component
public class SchedualServiceHiHystric implements SchedualServcieHi{
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry"+name;
    }
}
