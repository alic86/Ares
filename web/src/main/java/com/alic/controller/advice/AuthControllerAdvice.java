package com.alic.controller.advice;

import com.alic.controller.IndexController;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * @author suxingzhe
 * @create 2018-10-15 下午4:33
 **/
@ControllerAdvice(value = "com.alic.controller", basePackageClasses = {IndexController.class})
public class AuthControllerAdvice {
    public void controllerIntercept(){
        System.out.println("########controllerIntercept########");
    }
}
