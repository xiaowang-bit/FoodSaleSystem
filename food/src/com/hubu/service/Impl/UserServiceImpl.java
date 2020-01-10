package com.hubu.service.Impl;

import com.alibaba.druid.sql.visitor.functions.If;
import com.hubu.Enum.ResponseEnum;
import com.hubu.mapper.UserMapper;
import com.hubu.model.ResultMsg;
import com.hubu.model.User;
import com.hubu.service.UserService;
import com.hubu.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper uq;

    @Override
    public Response UpdateMyInfo(User user) {
        int row = uq.updateUser(user);
        if (row>=0){
            return Response.response(ResponseEnum.Success).add("msg","更新成功");
        }else {
            return Response.response(ResponseEnum.Fail).add("msg","更新失败");
        }
    }
    @Override
    public Response Login(String name, String pwd) {
        User user = uq.queryUserByName(name);
        if (user==null){
            return Response.response(ResponseEnum.Fail).add("msg","登录失败！用户名不存在");
        }else {
            User user2 = new User();
            user2.setPassword(pwd);
            user2.setUsername(name);
            User user1 = uq.queryUserByPwd(user2);
            if(user1!=null){
                Response r=Response.response(ResponseEnum.Success).add("user",user1);
                return r.add("msg","恭喜你！登录成功");
            }else {
                return Response.response(ResponseEnum.Fail).add("msg","登录失败！密码错误");
            }
        }
    }

    @Override
    public Response Register(User user) {
        User u = uq.queryUserByName(user.getUsername());
        if(u==null){
            int row = uq.addUser(user);
            if (row>0){
                return Response.response(ResponseEnum.Success).add("msg","恭喜你！注册成功");
            }else {
                return Response.response(ResponseEnum.Fail).add("msg","注册失败！请联系管理员");
            }
        }else {
            return Response.response(ResponseEnum.Fail).add("msg","注册失败！用户名已经存在");
        }
    }

    public List<User> queryUser(){
        return uq.queryOrder();
    }

}
