package com.hubu.controller;

import com.hubu.Enum.ResponseEnum;
import com.hubu.model.Cart;
import com.hubu.model.ResultMsg;
import com.hubu.model.User;
import com.hubu.service.UserService;
import com.hubu.utils.MailUtils;
import com.hubu.utils.Md5Util;
import com.hubu.utils.Response;
import com.hubu.utils.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.Flags;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        try {
            pwd=Md5Util.encodeByMd5(pwd);
        }catch (Exception e){
            System.out.println(e);
        }
        Response resultMsg = us.Login(username, pwd);
        request.getSession().setAttribute("user", resultMsg.getMap().get("user"));
        Cart cart = new Cart();
        request.getSession().setAttribute("cart", cart);
        return resultMsg;
    }

    @RequestMapping("/LRegister")
    @ResponseBody
    public Response LRegister(User user, HttpServletRequest request) {
        user=new User(UuidUtil.getUuid(),"xiaohong","2383","17841134123","a92agdf1@qq.com");
        Response resultMsg = null;
        if (user != null) {
            Pattern p = null;
            Matcher m = null;
            boolean flg = false;
            //匹配用户名
            String name = user.getUsername();
            p = Pattern.compile("^[a-zA-Z]{1}[a-zA-Z0-9_]{1,15}$");
            m = p.matcher(name);
            flg = m.matches();
            if (flg) {
                //密码校验
                String password = user.getPassword();
                p = Pattern.compile("^[a-zA-Z0-9]{1,16}$");
                m = p.matcher(password);
                flg = m.matches();
                if (flg) {
                    //电话校验
                    String phone = user.getCellphone();
                    p = Pattern.compile("^[0-9]{11}$");
                    m = p.matcher(phone);
                    flg = m.matches();
                    if (flg) {
                        //邮箱校验
                        String email = user.getEmail();
                        p = Pattern.compile("^\\w+[@]\\w+[.]\\w+$");
                        m = p.matcher(email);
                        flg = m.matches();
                        if (flg) {
                            //校验成功，添加信息,然后注册
                            user.setId(UuidUtil.getUuid());
                            try {
                                user.setPassword(Md5Util.encodeByMd5(user.getPassword()));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            resultMsg = us.Register(user);
                            return resultMsg;
                        }
                    }
                }
            }
            resultMsg = Response.response(ResponseEnum.Fail).add("msg", "注册失败");
            return resultMsg;
        } else {
            resultMsg = Response.response(ResponseEnum.Fail).add("msg", "注册失败");
            return resultMsg;
        }
    }
}
