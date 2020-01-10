package com.hubu.service;

import com.hubu.model.ResultMsg;
import com.hubu.model.User;
import com.hubu.utils.Response;

import java.util.List;


public interface UserService {
    public List<User> queryUser();
    public Response Login(String name, String pwd);
    public Response Register(User user);
}
