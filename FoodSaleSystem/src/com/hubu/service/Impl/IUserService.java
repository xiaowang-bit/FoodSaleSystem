package com.hubu.service.Impl;

import com.hubu.mapper.queryUsers;
import com.hubu.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author star
 * @version 1.0
 * @date 2020/1/9 16:18
 * @description 服务用户类
 */
public class IUserService {
    @Autowired
    private  queryUsers qu;

    public static void main(String[] args) {
       IUserService IU=new IUserService();
        System.out.println(IU.qu.query());
    }
}
