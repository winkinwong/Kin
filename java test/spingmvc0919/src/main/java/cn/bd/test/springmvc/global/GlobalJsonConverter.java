package cn.bd.test.springmvc.global;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;


import java.util.ArrayList;
import java.util.List;

/**
* @Description: 全局fastjson转换器，处理返回json结果null值
* @Author: 黄永健
* @Date: 2019/9/20
*/
@Configuration
public class GlobalJsonConverter {
    @Bean
    public HttpMessageConverters customConverters() {
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.QuoteFieldNames, SerializerFeature.WriteDateUseDateFormat, SerializerFeature.WriteNonStringValueAsString);

        FastJsonHttpMessageConverter fastJson = new FastJsonHttpMessageConverter();
        fastJson.setFastJsonConfig(fastJsonConfig);
        List<MediaType> mediaTypeList = new ArrayList<>();
        mediaTypeList.add(MediaType.valueOf("application/json;charset=UTF-8"));
        mediaTypeList.add(MediaType.valueOf("text/html;charset=UTF-8"));
        fastJson.setSupportedMediaTypes(mediaTypeList);
        return new HttpMessageConverters(fastJson);
    }
}
