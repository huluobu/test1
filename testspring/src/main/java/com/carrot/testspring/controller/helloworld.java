package com.carrot.testspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 注解方式
 * */
@Controller
public class helloworld {
    @RequestMapping(value = "/hellow",method= RequestMethod.GET)
    @ResponseBody
    public String hellow(){
        return "hellow carrot";
    }

}
