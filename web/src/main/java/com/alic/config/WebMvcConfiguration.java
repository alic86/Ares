package com.alic.config;

import com.alic.http.message.PropertiesUserHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * 自定义web mvc配置
 * @author suxingzhe
 * @create 2018-06-07 下午5:26
 **/
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
    /**
     * 设置appliation/xml为默认头部信息转换器
     * @param converters
     */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
//        converters.set(0, new MappingJackson2XmlHttpMessageConverter());
        converters.set(0, new PropertiesUserHttpMessageConverter());
    }
}
