package com.carrot.testspring.service.imp;


import com.carrot.testspring.dao.UserRepository;
import com.carrot.testspring.entities.User;
import com.carrot.testspring.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Optional;

@Service
public class userServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public void delete(int id) {
        userRepository.deleteById(id);

    }

    @Override
    public void insert(User user) {
        userRepository.save(user);
    }

    @Override
    public int update(User user) {
        userRepository.save(user);
        return 0;
    }

    @Override
    public User selectById(int id) {
        Optional<User> optional=userRepository.findById(id);
        User user=optional.get();
        return user;
    }

    @Override
    public Iterator<User> selectAll(int pageNum, int pageSize) {
        return null;
    }
}

