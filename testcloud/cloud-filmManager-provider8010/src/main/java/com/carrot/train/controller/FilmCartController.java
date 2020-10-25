package com.carrot.train.controller;

import com.carrot.train.entity.MatchUnionFilm;
import com.carrot.train.service.Imp.FilmMatchServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: carrot
 * @Date: 2020/10/9 08:50
 * @Description:
 */
@RequestMapping("cart")
@Controller
public class FilmCartController {
    @Autowired
    private FilmMatchServiceImp filmMatchServiceImp;

    @RequestMapping("/page")
    public String toCart(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(true);
        System.out.println(session);

        return "pages/cart/cart";
    }

    @RequestMapping("addseats")
    public String addMovieSeats(HttpServletRequest request, HttpServletResponse response,Integer matchid) {
        System.out.println("matchid is "+matchid);
        Map<String,String> params=new HashMap();
        params.put("id", String.valueOf(matchid));
        List<MatchUnionFilm> matchUnionFilmList = filmMatchServiceImp.queryByParams(params);
        MatchUnionFilm matchUnionFilm = matchUnionFilmList.get(0);
        request.setAttribute("filmmatch",matchUnionFilmList);
        request.setAttribute("totalprice",matchUnionFilm.getFilmprice());
        return "pages/cart/cart";

    }


}
