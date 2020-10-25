package com.carrot.train.mapper;

import com.carrot.train.entity.FilmOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @Author: carrot
 * @Date: 2020/10/5 10:58
 */
@Mapper
public interface FilmOrderMapper extends BaseMapper {
    List<FilmOrder> selectFilmOrderByParams(Map<String, String> map);
}
