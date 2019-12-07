package com.kin.test.springboot.global;

import com.kin.test.springboot.global.filter.SessionUserFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class GlobalFilterRegistration {

    /**
     * 先实现 LogFilter, LogFilter 需继承 OncePerRequestFilter
     * 实例化 FilterRegistrationBean, 完成 Filter 的注册
     * @return
     */
    @Bean
    public FilterRegistrationBean sessionUserFilterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();

        registrationBean.setName("sessionUserFilter");
        registrationBean.setOrder(2);
        registrationBean.setFilter(new SessionUserFilter());
        registrationBean.setUrlPatterns(Arrays.asList(new String[] {
                "/*"
        }));

        return registrationBean;
    }

}
