package com.hubu.mapper;

import com.hubu.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    public List<User> queryOrder();
}
