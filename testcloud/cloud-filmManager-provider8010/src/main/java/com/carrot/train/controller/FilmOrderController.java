package com.carrot.train.controller;

import com.carrot.train.entity.Film;
import com.carrot.train.entity.FilmMatch;
import com.carrot.train.entity.FilmOrder;
import com.carrot.train.service.Imp.FilmMatchServiceImp;
import com.carrot.train.service.Imp.FilmOrderImp;
import com.carrot.train.service.Imp.FilmServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: carrot
 * @Date: 2020/10/6 12:55
 */
@RequestMapping("manager/order")
@Controller
public class FilmOrderController {
    @Autowired
    private FilmServiceImp filmServiceImp;
    @Autowired
    private FilmOrderImp filmOrderImp;

    @Autowired
    private FilmMatchServiceImp filmMatchServiceImp;


    @RequestMapping("/list")
    private String selectAllOrder(HttpServletRequest request, HttpServletResponse response) {
        Integer uid = (Integer) request.getSession().getAttribute("uid");
        Map<String, String> params=new HashMap<String, String>();
        params.put("userid", String.valueOf(uid));
        List<FilmOrder> list = filmOrderImp.selectFilmOrderByParams(params);
        request.setAttribute("orderlist",list);
        return "pages/manager/filmorder_manager.html";
    }

    @RequestMapping("/add")
    private String  insertMovieOrder(HttpServletRequest request, HttpServletResponse response, Integer matchid,String seatnum) {
        FilmMatch filmMatch = (FilmMatch) filmMatchServiceImp.findByPrimaryKey(matchid);
        Film film = filmServiceImp.findByPrimaryId(filmMatch.getFilmid());
        Integer uid = (Integer)request.getSession().getAttribute("uid");
        String reseats = filmMatch.getReseats();
        String msg = null;
        String targetstring = null;
        String result = null;
        if (reseats.indexOf(seatnum) != -1) {
            if (reseats.indexOf(seatnum + ",") != -1) {
                targetstring = seatnum + ",";
                result=reseats.replace(targetstring, "");
                System.out.println(result);
            } else {
                targetstring = "," + seatnum;
                result=reseats.replace(targetstring, "");
                System.out.println(result);
            }
        } else {
            msg = "你选择的座位不存在";
            request.setAttribute("msg", msg);
            return "error";
        }

        filmMatch.setReseats(result);
        filmMatch.setSales(filmMatch.getSales()+1);
        film.setSales(film.getSales() + 1);
        FilmOrder filmOrder = new FilmOrder(null, filmMatch.getId(), uid, new Date(),new Date(),seatnum,filmMatch.getFilmprice(),null,"Y");
        filmOrderImp.insert(filmOrder);
        filmMatchServiceImp.update(filmMatch);
        filmServiceImp.update(film);
        request.setAttribute("filmorder",filmOrder);
        return "pages/cart/checkout";
    }


    private  void  updateMovieOrder() {
        FilmOrder filmOrder = (FilmOrder) filmOrderImp.findByPrimaryKey(1);
        filmOrder.setPrice(new BigDecimal("72"));
        filmOrderImp.update(filmOrder);
    }
}
