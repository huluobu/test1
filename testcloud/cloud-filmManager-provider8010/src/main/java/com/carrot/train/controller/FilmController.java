package com.carrot.train.controller;

import com.carrot.testcloud.entities.CommonResult;
import com.carrot.train.entity.Film;
import com.carrot.train.service.Imp.FilmServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: carrot
 * @Date: 2020/10/6 9:52
 */
@RequestMapping("manager/film")
@RestController
public class FilmController {
    @Autowired
    private FilmServiceImp filmServiceImp;

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;



//    @RequestMapping("/list")
//    private String selectAllFilm(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
//        List<Film> list = filmServiceImp.queryAllFilm();
//        httpServletRequest.setAttribute("filmlist",list);
//        return "pages/manager/book_manager";
//    }

    @RequestMapping("/list")
    private CommonResult selectAllFilm() {
        CommonResult result = new CommonResult();
        List<Film> list = filmServiceImp.queryAllFilm();
        result.setCode(0000);
        result.setData(list);
        result.setMessage("success");
        return result;
    }


   /* @RequestMapping("/add")
    public String insertMovie(HttpServletRequest request,HttpServletResponse response,String filmname,
                            String filmtype,String filminfo,Double filmprice,Integer sales,
                            String status) {

        Film film = new Film();
        film.setStatus(status);
        film.setFilmname(filmname);
        film.setFilmtype(filmtype);
        film.setFilmprice(new BigDecimal(filmprice));
        film.setFilminfo(filminfo);
        film.setSales(sales);
        filmServiceImp.insert(film);
        kafkaTemplate.send("newfilm-0", filmname);
        return "redirect:list";
    }*/

    @RequestMapping("/add")
    public CommonResult insertMovie(@RequestBody HashMap<String, Object> map) {

        String filmname = (String) map.get("filmname");
        String filmtype = (String) map.get("filmtype");
        String filminfo = (String) map.get("filminfo");
        double filmprice = (double) map.get("filmprice");
        Integer sales = (Integer) map.get("sales");
        String status = (String) map.get("status");

        CommonResult result = new CommonResult();
        Film film = new Film();
        film.setStatus(status);
        film.setFilmname(filmname);
        film.setFilmtype(filmtype);
        film.setFilmprice(new BigDecimal(filmprice));
        film.setFilminfo(filminfo);
        film.setSales(sales);
        filmServiceImp.insert(film);
//        kafkaTemplate.send("newfilm-0", filmname);
        result.setCode(0000);
        result.setData(film);
        result.setMessage("success");
        return result;
    }

/*    @RequestMapping("/delete")
    public String deleteMovie(HttpServletRequest request,HttpServletResponse response,Integer id) {
        Film film = (Film) filmServiceImp.findByPrimaryKey(id);
        film.setStatus("N");
        filmServiceImp.update(film);
        return "redirect:list";
    }*/


    @RequestMapping("/delete")
    public CommonResult deleteMovie(@RequestBody HashMap<String, Object> map) {
        CommonResult result = new CommonResult();
        Integer id = (Integer) map.get("id");
        Film film = (Film) filmServiceImp.findByPrimaryKey(id);
        film.setStatus("N");
        filmServiceImp.update(film);
        result.setCode(0000);
        result.setData(film);
        result.setMessage("success");
        return result;
    }
//    @RequestMapping("/query")
//    public String queryMovie(HttpServletRequest request,HttpServletResponse response,Integer id) {
//        Film film = (Film) filmServiceImp.findByPrimaryKey(id);
//        request.setAttribute("film",film);
//        return "pages/manager/book_edit";
//    }

    @RequestMapping("/query")
    public CommonResult queryMovie(@RequestBody HashMap<String, Object> map) {
        CommonResult result = new CommonResult();
        Integer id = (Integer) map.get("id");
        Film film = filmServiceImp.findByPrimaryId(id);
        result.setCode(0000);
        result.setData(film);
        result.setMessage("success");
        return result;
    }


//    @RequestMapping("/update")
//    public String updateMovie(HttpServletRequest request,HttpServletResponse response, Integer id,String filmname,
//                            String filmtype,String filminfo,Double filmprice,Integer sales, String status) {
//
//        Film film = (Film) filmServiceImp.findByPrimaryKey(id);
//        film.setStatus(status);
//        film.setFilmname(filmname);
//        film.setFilmtype(filmtype);
//        film.setFilmprice(new BigDecimal(filmprice));
//        film.setFilminfo(filminfo);
//        film.setSales(sales);
//        filmServiceImp.update(film);
//        return "redirect:list";
//    }

    @RequestMapping("/update")
    public CommonResult updateMovie(@RequestBody HashMap<String, Object> map) {

        CommonResult result = new CommonResult();
        Integer id = (Integer) map.get("id");
        String filmname = (String) map.get("filmname");
        String filmtype = (String) map.get("filmtype");
        String filminfo = (String) map.get("filminfo");
        double filmprice = (double) map.get("filmprice");
        Integer sales = (Integer) map.get("sales");
        String status = (String) map.get("status");

        Film film = (Film) filmServiceImp.findByPrimaryKey(id);
        film.setStatus(status);
        film.setFilmname(filmname);
        film.setFilmtype(filmtype);
        film.setFilmprice(new BigDecimal(filmprice));
        film.setFilminfo(filminfo);
        film.setSales(sales);
        filmServiceImp.update(film);
        result.setCode(0000);
        result.setData(film);
        result.setMessage("success");
        return result;
    }
}
