package com.hubu.service.Impl;

import com.hubu.mapper.UserMapper;
import com.hubu.model.ResultMsg;
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
    public ResultMsg Login(String name, String pwd) {
        User user = uq.queryUserByName(name);
        if (user==null){
            return new ResultMsg("对不起，你的用户名错误",false,null);
        }else {
            User user1 = uq.queryUserByPwd(pwd);
            if(user1!=null){
                return new ResultMsg("恭喜你登录成功",true,user1);
            }else {
                return new ResultMsg("你的密码错误",false,null);
            }
        }
    }

    public List<User> queryUser(){
        return uq.queryOrder();
    }

}
