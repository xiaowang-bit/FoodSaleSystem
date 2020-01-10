package com.hubu.controller;

import com.hubu.model.Cart;
import com.hubu.model.ResultMsg;
import com.hubu.model.User;
import com.hubu.service.UserService;
import com.hubu.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    @RequestMapping("/ULogin")
    @ResponseBody
    public Response ULogin(String username, String pwd, HttpServletRequest request) {
        Response resultMsg = us.Login("xiaowang", "2383");
        request.getSession().setAttribute("user",resultMsg.getMap().get("user"));
        Cart cart=new Cart();
        request.getSession().setAttribute("cart",cart);
        return resultMsg;
    }
    @RequestMapping("/LRegister")
    @ResponseBody
    public Response LRegister(User user, HttpServletRequest request) {
        Response resultMsg=null;
        if(user!=null){
            resultMsg = us.Register(user);
            return resultMsg;
        }else {
            return resultMsg;
        }
    }



}
