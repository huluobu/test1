package com.carrot.train.mapper;

import org.apache.ibatis.annotations.Param;


public interface BaseMapper {
    /**
     * 修改
     * @param object
     */
    void update(Object object);

    /**
     * 新增
     * @param object
     */
    void insert(Object object);

    /**
     * 根据主键查询
     * @param primaryKey
     * @return
     */
    Object findByPrimaryKey(@Param("primaryKey") Object primaryKey);
}
