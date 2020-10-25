package com.carrot.train.service.Imp;


import com.carrot.train.entity.User;
import com.carrot.train.mapper.UsersMapper;
import com.carrot.train.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UsersMapper usersMapper;


    @Override
    public void update(Object object) {
        usersMapper.update(object);
    }

    @Override
    public void insert(Object object) {
        usersMapper.insert(object);

    }

    @Override
    public User findByPrimaryKey(Object primaryKey) {
        User user =(User)usersMapper.findByPrimaryKey(primaryKey);
        return user;
    }

    public User findByUserName(Object primaryKey) {
        User user = usersMapper.findByUserName(primaryKey);
        return user;
    }

}
