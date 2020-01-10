package com.hubu.service;

import com.hubu.model.User;

import java.util.List;


public interface UserService {
    public List<User> queryUser();
    public User Login(String name,String pwd);
}
