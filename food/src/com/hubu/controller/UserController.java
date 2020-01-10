package com.hubu.controller;

import com.hubu.model.User;
import com.hubu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService us;

    @RequestMapping("/test")
    @ResponseBody
    public List<User> userquery() {
        List<User> list = us.queryUser();
        System.out.println(list);
        return list;
    }

}
