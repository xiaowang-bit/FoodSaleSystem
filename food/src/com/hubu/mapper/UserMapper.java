package com.hubu.mapper;

import com.hubu.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    public List<User> queryOrder();
    public int addUser(User user);
    public int updateUser(User user);
    public int updatePwd(User user);
    public User queryUserByName(String name);
    public User queryUserByPwd(User user);
    public User queryUserByEmail(String email);

}
