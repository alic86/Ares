package com.alic;

import com.alic.interceptor.DefaultHandlerInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App extends WebMvcConfigurerAdapter implements ErrorPageRegistrar {
    public static void main( String[] args ) {
        SpringApplication.run(App.class);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new DefaultHandlerInterceptor());
    }

    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        registry.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404.html"));
    }
}
