package com.carrot.train.controller;

import com.carrot.testcloud.entities.CommonResult;
import com.carrot.train.entity.MatchUnionFilm;
import com.carrot.train.service.ProviderFilmManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author: carrot
 * @Date: 2020/10/25 9:18
 */
@Controller
public class FilmConsumerController {
    @Resource
    private ProviderFilmManager providerFilmManager;

    @RequestMapping("consumer/home")
    public String toHomepage(HttpServletRequest request) {
        CommonResult result = providerFilmManager.toHomepage();
        System.out.println(request);
        List<MatchUnionFilm> list = (List<MatchUnionFilm>) result.getData();
        request.setAttribute("film",list);
        return result.getMessage();
    }
}
