package com.hubu.service;

import com.hubu.model.ResultMsg;
import com.hubu.model.User;

import java.util.List;


public interface UserService {
    public List<User> queryUser();
    public ResultMsg Login(String name, String pwd);
}
