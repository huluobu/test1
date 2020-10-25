package com.carrot.train.mapper;

import com.carrot.train.entity.Film;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: carrot
 * @Date: 2020/10/5 10:54
 */
@Mapper
public interface FilmMapper extends BaseMapper{
    Film findByPrimaryId(Integer fid);
    Film findByFilmname(String filmname);
    List<Film> selectAllFilm();
}
