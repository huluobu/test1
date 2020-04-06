package com.carrot.testspring.controller;

import com.carrot.testspring.exceptiom.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyexcetionHandler {
/*    @ResponseBody
    @ExceptionHandler(UserNotExistException.class)
    public Map<String, Object> handleException(Exception e){
        Map<String,Object> map=new HashMap<>();
        map.put("code","user.notexist");
        map.put("message",e.getMessage());
        return map;

    }*/

    @ExceptionHandler(UserNotExistException.class)
    public String handleException(Exception e, HttpServletRequest request){

        request.setAttribute("javax.servlet.error.status_code",400);

        Map<String,Object> map=new HashMap<>();
        map.put("code","user.notexist");
        map.put("message",e.getMessage());
        request.setAttribute("ext",map);
        return "forward:/error";

    }
}
