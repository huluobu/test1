package com.carrot.train.service.Imp;

import com.carrot.train.entity.Film;
import com.carrot.train.mapper.FilmMapper;
import com.carrot.train.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: carrot
 * @Date: 2020/10/5 11:05
 */
@Service
public class FilmServiceImp implements FilmService {
    @Autowired
    private FilmMapper filmMapper;

    @Override
    public void update(Object object) {
        filmMapper.update(object);
    }

    @Override
    public void insert(Object object) {
        filmMapper.insert(object);

    }

    @Override
    public Object findByPrimaryKey(Object primaryKey) {
        return filmMapper.findByPrimaryKey(primaryKey);
    }

    public List<Film> queryAllFilm() {
        List<Film> list = filmMapper.selectAllFilm();
        return list;
    }
    public Film findByPrimaryId(Integer primaryKey) {
        return filmMapper.findByPrimaryId(primaryKey);
    }

    public Film findByFilmname(String filmname) {
        return filmMapper.findByFilmname(filmname);
   }
}
