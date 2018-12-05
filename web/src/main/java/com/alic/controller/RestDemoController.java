package com.alic.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author suxingzhe
 * @create 2018-06-06 下午4:44
 **/
@RestController
public class RestDemoController {

    @GetMapping("/404.html")
    public Object handlePageNotFound(HttpStatus status, HttpServletRequest request, Throwable throwable){
        Map<String, Object> errors = new HashMap<>();
        errors.put("statusCode", request.getAttribute("javax.servlet.error.status_code"));
        errors.put("requestUri", request.getAttribute("javax.servlet.error.request_uri"));

        return errors;
    }

    @GetMapping("/exc")
    public String exception(){
        throw new NullPointerException("空指针！");
    }
}
