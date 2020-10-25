package com.carrot.train.controller;

import com.carrot.train.entity.Film;
import com.carrot.train.service.Imp.FilmServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: carrot
 * @Date: 2020/10/6 9:52
 */
@RequestMapping("manager/film")
@Controller
public class FilmController {
    @Autowired
    private FilmServiceImp filmServiceImp;

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @RequestMapping("/page")
    public String toEditpage(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request.getSession().getAttribute("uid"));
        request.setAttribute("film",new Film());
        return "pages/manager/book_edit";
    }

    @RequestMapping("/list")
    private String selectAllFilm(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        List<Film> list = filmServiceImp.queryAllFilm();
        httpServletRequest.setAttribute("filmlist",list);
        return "pages/manager/book_manager";
    }


    @RequestMapping("/add")
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
    }

    @RequestMapping("/delete")
    public String deleteMovie(HttpServletRequest request,HttpServletResponse response,Integer id) {
        Film film = (Film) filmServiceImp.findByPrimaryKey(id);
        film.setStatus("N");
        filmServiceImp.update(film);
        return "redirect:list";
    }

    @RequestMapping("/query")
    public String queryMovie(HttpServletRequest request,HttpServletResponse response,Integer id) {
        Film film = (Film) filmServiceImp.findByPrimaryKey(id);
        request.setAttribute("film",film);
        return "pages/manager/book_edit";
    }
    @RequestMapping("/update")
    public String updateMovie(HttpServletRequest request,HttpServletResponse response, Integer id,String filmname,
                            String filmtype,String filminfo,Double filmprice,Integer sales, String status) {

        Film film = (Film) filmServiceImp.findByPrimaryKey(id);
        film.setStatus(status);
        film.setFilmname(filmname);
        film.setFilmtype(filmtype);
        film.setFilmprice(new BigDecimal(filmprice));
        film.setFilminfo(filminfo);
        film.setSales(sales);
        filmServiceImp.update(film);
        return "redirect:list";
    }
}
