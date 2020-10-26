package com.carrot.train.controller;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.carrot.testcloud.entities.CommonResult;
import com.carrot.train.entity.Film;
import com.carrot.train.entity.MatchUnionFilm;
import com.carrot.train.service.ProviderFilmManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping("consumer/manager/film/list")
    public String toFilmList(HttpServletRequest request) {
        CommonResult result = providerFilmManager.toList();
        System.out.println(result);
        List<Film> list = (List<Film>) result.getData();
        request.setAttribute("filmlist",list);
        return "pages/manager/book_manager";
    }



    @RequestMapping("consumer/manager/film/query")
    public String queryMovie(HttpServletRequest request,Integer id) {
        HashMap<String, Object> map= new HashMap<String, Object>();
        map.put("id", id);
        CommonResult result = providerFilmManager.toQuery(map);
        System.out.println(result);
        JSONObject jsonObject = new JSONObject(result.getData());
        Film film = JSONUtil.toBean(jsonObject, Film.class);
        request.setAttribute("film",film);
        return "pages/manager/book_edit";
    }

    @RequestMapping("consumer/manager/film/update")
    public String updateMovie(HttpServletRequest request,HttpServletResponse response, Integer id,String filmname,
                           String filmtype,String filminfo,Double filmprice,Integer sales, String status) {
        HashMap<String, Object> map= new HashMap<String, Object>();
        map.put("id", id);
        map.put("filmname", filmname);
        map.put("filmtype", filmtype);
        map.put("filminfo", filminfo);
        map.put("filmprice", filmprice);
        map.put("sales", sales);
        map.put("status", status);

        CommonResult result = providerFilmManager.toUpdate(map);
        return "redirect:list";
    }

    @RequestMapping("consumer/manager/film/add")
    public String addMovie(HttpServletRequest request,HttpServletResponse response,String filmname,
                           String filmtype,String filminfo,Double filmprice,Integer sales,
                           String status) {
        HashMap<String, Object> map= new HashMap<String, Object>();
        map.put("filmname", filmname);
        map.put("filmtype", filmtype);
        map.put("filminfo", filminfo);
        map.put("filmprice", filmprice);
        map.put("sales", sales);
        map.put("status", status);

        CommonResult result = providerFilmManager.toAdd(map);
        System.out.println(result);
        return "redirect:list";
    }

    @RequestMapping("consumer/manager/film/page")
    public String toEditpage(HttpServletRequest request) {
        System.out.println(request.getSession().getAttribute("uid"));
        request.setAttribute("film",new Film());
        return "pages/manager/book_edit";
    }

    @RequestMapping("consumer/manager/film/delete")
    public String deleteMovie(HttpServletRequest request,HttpServletResponse response,Integer id) {
        HashMap<String, Object> map= new HashMap<String, Object>();
        map.put("id", id);
        CommonResult result = providerFilmManager.toDelete(map);
        System.out.println(result);
        return "redirect:list";
    }
}
