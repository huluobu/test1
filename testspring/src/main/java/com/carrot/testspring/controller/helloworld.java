package com.carrot.testspring.controller;

import com.carrot.testspring.exceptiom.UserNotExistException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

/**
 * 注解方式
 * */
@Controller
public class helloworld {
    @Value("${persion.lastName}")
    private  String name;
    @RequestMapping(value = "/hellow",method= RequestMethod.GET)
    @ResponseBody
    public String hellow(@RequestParam("user") String username){
        if(username.equals("aaa")){
            throw new UserNotExistException();
        }
        return "hellow carrot"+name;
    }

    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("hello","<h1>你好</h1>");
        map.put("users", Arrays.asList("zhangsan","lisi","wangfu"));
        return "success";
    }

/*    @RequestMapping({"/","/index.html"})
    public String index(){
        return "index.html";
    }*/


}
