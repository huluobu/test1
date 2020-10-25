package com.carrot.train.controller;

import com.carrot.testcloud.entities.CommonResult;
import com.carrot.train.entity.MatchUnionFilm;
import com.carrot.train.service.Imp.FilmMatchServiceImp;
import com.carrot.train.service.Imp.FilmServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: carrot
 * @Date: 2020/10/9 14:13
 * @Description:
 */
//@RequestMapping("pages")
@RestController
public class CommonDispatcherController {
    @Autowired
    private FilmServiceImp filmServiceImp;

    @Autowired
    private FilmMatchServiceImp filmMatchServiceImp;

    @RequestMapping("/home")
    public CommonResult toHomepage() {
        Map<String, String> params=new HashMap<>();
        List<MatchUnionFilm> list = filmMatchServiceImp.queryByParams(params);
        CommonResult result = new CommonResult();
        result.setCode(0000);
        result.setData(list);
        result.setMessage("home");
        return result;
    }

    @RequestMapping("/user")
    public String toUserpage(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request.getSession().getAttribute("uid"));
        return "pages/user/login";
    }

    @RequestMapping("/regist")
    public String toReisghtpage(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request.getSession().getAttribute("uid"));
        return "pages/user/regist";
    }

    @RequestMapping("/manager")
    public String toManagerpage(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request.getSession().getAttribute("uid"));
        return "pages/manager/manager";
    }
}
