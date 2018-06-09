package com.alic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
