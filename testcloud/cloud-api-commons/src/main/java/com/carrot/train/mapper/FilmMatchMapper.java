package com.carrot.train.mapper;

import com.carrot.train.entity.FilmMatch;
import com.carrot.train.entity.MatchUnionFilm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @Author: carrot
 * @Date: 2020/10/5 10:57
 */
@Mapper
public interface FilmMatchMapper extends BaseMapper {
    List<FilmMatch> selectAllFilmMatch();
    List<MatchUnionFilm> selectFilmMatchByParams(Map<String, String> map);
}
