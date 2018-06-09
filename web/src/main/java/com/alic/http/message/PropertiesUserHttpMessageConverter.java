package com.alic.http.message;

import com.alic.domain.User;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractGenericHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.lang.Nullable;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Properties;

/**
 * 自定义User消息转换器
 *
 * @author suxingzhe
 * @create 2018-06-07 下午5:40
 **/
public class PropertiesUserHttpMessageConverter extends AbstractGenericHttpMessageConverter<User> {

    public PropertiesUserHttpMessageConverter(){
        super(MediaType.valueOf("application/properties+user"));
        setDefaultCharset(Charset.forName("UTF-8"));
    }

    protected boolean supports(Class<?> clazz){
        return clazz.isAssignableFrom(User.class);
    }

    @Override
    protected void writeInternal(User user, @Nullable Type type, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        OutputStream outputStream = httpOutputMessage.getBody();
        Properties properties = new Properties();
        properties.setProperty("user.id", String.valueOf(user.getId()));
        properties.setProperty("user.name", user.getName());

        properties.store(new OutputStreamWriter(outputStream, getDefaultCharset()), "Written by app server!");

    }

    @Override
    protected User readInternal(Class<? extends User> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        InputStream inputStream = httpInputMessage.getBody();
        Properties properties = new Properties();
        properties.load(new InputStreamReader(inputStream, getDefaultCharset()));

        User user = new User();
        user.setId(Long.valueOf(properties.getProperty("user.id")));
        user.setName(properties.getProperty("user.name"));

        return user;
    }

    @Override
    public User read(Type type, @Nullable Class<?> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }
}
