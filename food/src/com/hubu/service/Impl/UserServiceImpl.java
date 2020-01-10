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
    private UserMapper qo;
    public List<User> queryUser(){
        return qo.queryOrder();
    }
}
