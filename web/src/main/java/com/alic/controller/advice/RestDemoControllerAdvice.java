package com.alic.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author suxingzhe
 * @create 2018-06-06 下午4:47
 **/
@RestControllerAdvice
public class RestDemoControllerAdvice {
    @ExceptionHandler(NoHandlerFoundException.class)
    public Object pageNotFound(HttpStatus status, HttpServletRequest request, Throwable throwable){
        Map<String, Object> errors = new HashMap<>();
        errors.put("statusCode", request.getAttribute("javax.servlet.error.status_code"));
        errors.put("requestUri", request.getAttribute("javax.servlet.error.request_uri"));

        return errors;
    }

    @ExceptionHandler(NullPointerException.class)
    public Object exceptionMessage(Throwable throwable){
        Map<String, Object> errors = new HashMap<>();
        errors.put("statusCode", throwable.getMessage());
        return errors;
    }
}
