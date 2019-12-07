package com.kin.maven.springboot.global;

import com.kin.maven.springboot.filter.LogFilter;
import com.kin.maven.springboot.filter.SessionFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class GlobalFilterRegistrator {
    @Bean
    @Autowired
    public FilterRegistrationBean filterRegistrationBean(LogFilter logFilter){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setName("logFilter");
        filterRegistrationBean.setOrder(1);
        filterRegistrationBean.setFilter(logFilter);
        filterRegistrationBean.setUrlPatterns(Arrays.asList(new String[]{
                "/*"
        }));
        return filterRegistrationBean;
    }



    @Bean
    public FilterRegistrationBean sessionFilterRegistrationBean(){
        FilterRegistrationBean sessionFilterRegistrationBean = new FilterRegistrationBean();
        sessionFilterRegistrationBean.setName("sessionFilter");
        sessionFilterRegistrationBean.setOrder(2);
        sessionFilterRegistrationBean.setFilter(new SessionFilter());
        sessionFilterRegistrationBean.setUrlPatterns(Arrays.asList(new String[]{
                "/*"
        }));
        return sessionFilterRegistrationBean;
    }
}
