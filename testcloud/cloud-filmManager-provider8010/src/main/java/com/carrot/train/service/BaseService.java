package com.carrot.train.service;

/**
 * @Author: carrot
 * @Date: 2020/9/28 11:07
 * @Description:
 */
public interface BaseService {
    void update(Object object);


    void insert(Object object);


    Object findByPrimaryKey(Object primaryKey);
}
