package com.carrot.testspring.service;

import com.carrot.testspring.entities.User;
import org.springframework.stereotype.Service;

import java.util.Iterator;


@Service
public interface UserService {
    /** 删除 */
    public void delete(int id);
    /** 增加*/
    public void insert(User user);
    /** 更新*/
    public int update(User user);
    /** 查询单个*/
    public User selectById(int id);
    /** 查询全部列表*/
    public Iterator<User> selectAll(int pageNum, int pageSize);
}
