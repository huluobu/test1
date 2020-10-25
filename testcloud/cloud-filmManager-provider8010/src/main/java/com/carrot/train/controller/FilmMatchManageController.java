package com.carrot.train.controller;

import com.carrot.train.entity.Film;
import com.carrot.train.entity.FilmMatch;
import com.carrot.train.entity.MatchUnionFilm;
import com.carrot.train.service.Imp.FilmMatchServiceImp;
import com.carrot.train.service.Imp.FilmServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: carrot
 * @Date: 2020/10/6 11:19
 */
@RequestMapping("manager/match")
@Controller
public class FilmMatchManageController {
    @Autowired
    private FilmServiceImp filmServiceImp;
    @Autowired
    private FilmMatchServiceImp filmMatchServiceImp;

    private String seats = "1,2,3,4,5,6,7,8,9,10,11,12";

    @RequestMapping("/page")
    public String toEditpage(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request.getSession().getAttribute("uid"));
        request.setAttribute("filmMatch",new FilmMatch());
        return "pages/manager/filmmatch_edit";
    }

    @RequestMapping("/list")
    private String selectAllFilmMatch(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        List<FilmMatch> list = filmMatchServiceImp.queryAllFilmMatch();
        httpServletRequest.setAttribute("filmMatchList",list);
        System.out.println(list);
        return "pages/manager/filmmatch_manager";
    }

    @RequestMapping("/add")
    public String insertMovieMatch(HttpServletRequest request, HttpServletResponse response, Integer filmid,
                                   String location, String halltype, Double filmprice, Integer sales,  String begindate,
                                   String reseats, String status) throws ParseException {

        SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd HH:mm" );
        String bt = begindate.replace("T", " ");
        Date creattime = sdf.parse(bt.toString());
        FilmMatch filmMatch=new FilmMatch(null,filmid,location,halltype,new BigDecimal(filmprice),
                                            sales,creattime,reseats,status);
//        FilmMatch filmMatch=new FilmMatch(null,7,"CBD店","3D",new BigDecimal(70),
//                                            0,new Date(),seats,"Y");
        filmMatchServiceImp.insert(filmMatch);
        return "redirect:list";
    }

    @RequestMapping("/delete")
    public String deleteMovie(HttpServletRequest request,HttpServletResponse response,Integer id) {
        FilmMatch filmMatch = (FilmMatch) filmMatchServiceImp.findByPrimaryKey(id);
        filmMatch.setStatus("N");
        filmMatchServiceImp.update(filmMatch);
        return "redirect:list";
    }

    @RequestMapping("/query")
    public String queryMovie(HttpServletRequest request,HttpServletResponse response,Integer id) {
        FilmMatch filmMatch = (FilmMatch) filmMatchServiceImp.findByPrimaryKey(id);
        request.setAttribute("filmMatch",filmMatch);
        return "pages/manager/filmmatch_edit";
    }


    @RequestMapping("/update")
    public String updateMovie(HttpServletRequest request, HttpServletResponse response,Integer id, Integer filmid,
                              String location, String halltype, Double filmprice, Integer sales,  String begindate,
                              String reseats, String status) throws ParseException {

        FilmMatch filmMatch = (FilmMatch) filmMatchServiceImp.findByPrimaryKey(id);
        SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd HH:mm" );
        String bt = begindate.replace("T", " ");
        Date creattime = sdf.parse(bt.toString());
        filmMatch.setBegindate(creattime);
        filmMatch.setFilmid(filmid);
        filmMatch.setReseats(reseats);
        filmMatch.setFilmprice(new BigDecimal(filmprice));
        filmMatch.setLocation(location);
        filmMatch.setHalltype(halltype);
        filmMatch.setSales(sales);
        filmMatch.setStatus(status);
        filmMatchServiceImp.update(filmMatch);
        return "redirect:list";
    }

    @RequestMapping("/submitmatch")
    public String querFilmByMatch(HttpServletRequest request, HttpServletResponse response,
                                  String location,String halltype,String begindatetime) {
        Map<String, String> params=new HashMap<>();
        params.put("location", location);
        params.put("halltype", halltype);
        params.put("begindate", begindatetime);
        Film film = filmServiceImp.findByPrimaryId(1);
//        params.put("location", "CBD店");
//        params.put("halltype", "3D");
//        params.put("begindate", "2020-10-10 09:00:00");
        List<MatchUnionFilm> list = filmMatchServiceImp.queryByParams(params);
        request.setAttribute("film",list);
        return "home";
    }

    // 消费监听
    @KafkaListener(topics = {"newfilm-0"})
    public void listenMQNewFilm(String data) {
        System.out.println(data);
        Film film = filmServiceImp.findByFilmname(data);
//        默认增加电影场次
        FilmMatch filmMatch=new FilmMatch(null,film.getId(),"CBD店","3D",new BigDecimal(70),
                                            0,new Date(),seats,"Y");
        filmMatchServiceImp.insert(filmMatch);


    }
}
