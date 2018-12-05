package com.alic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.security.auth.Subject;

/**
 * @author suxingzhe
 * @create 2018-06-07 上午9:57
 **/
@Controller
public class IndexController {
    @RequestMapping("")
    public String index(){
        return "index";
    }

    @ModelAttribute("model")
    public String name(){
        return "dd";
    }

    @GetMapping("vue")
    public String vue(){
        return "vue";
    }
}
