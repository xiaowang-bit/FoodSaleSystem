package com.hubu.service.Impl;

import com.hubu.mapper.UserMapper;
import com.hubu.model.User;
import com.hubu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper uq;

    @Override
    public User Login(String name,String pwd) {
        User user = uq.queryUserByName(name);
        if (user==null){
            return
        }
    }

    public List<User> queryUser(){
        return uq.queryOrder();
    }

}
