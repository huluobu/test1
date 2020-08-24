package com.carrot.testspring.controller;

import com.carrot.testspring.annotation.OperateLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author carrot
 */
@Controller
public class LoginController {

/*    @Autowired
    HttpSession session;*/

    @RequestMapping(method = RequestMethod.POST,value = "/user/login")
    @OperateLog(operateModule = "登录模块",operateDescription = "初始登录",operateType = "login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){
        if(!StringUtils.isEmpty(username) && "123456".equals(password)){
//            登录成功
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";

        }else{
            map.put("msg","用户名密码错误");
            return "login";
        }
    }
}
