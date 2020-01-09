package com.hubu.mapper;

import com.hubu.model.User;

import java.util.List;

/**
 * @author star
 * @version 1.0
 * @date 2020/1/9 16:12
 * @description 查找用户
 */
public interface queryUsers {
    public List<User> query();
}
