package com.carrot.train.service.Imp;

import com.carrot.train.entity.FilmOrder;
import com.carrot.train.mapper.FilmOrderMapper;
import com.carrot.train.service.FilmOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: carrot
 * @Date: 2020/10/6 12:34
 */
@Service
public class FilmOrderImp implements FilmOrderService {

    @Autowired
    private FilmOrderMapper filmOrderMapper;


    @Override
    public void update(Object object) {
        filmOrderMapper.update(object);
    }

    @Override
    public void insert(Object object) {
        filmOrderMapper.insert(object);
    }

    @Override
    public Object findByPrimaryKey(Object primaryKey) {
        return filmOrderMapper.findByPrimaryKey(primaryKey);
    }

    public List<FilmOrder> selectFilmOrderByParams(Map<String, String> map) {
        List<FilmOrder> list = filmOrderMapper.selectFilmOrderByParams(map);
        return list;
    }
}
