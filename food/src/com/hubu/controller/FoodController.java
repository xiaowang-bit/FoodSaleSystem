package com.hubu.controller;

import com.hubu.Enum.ResponseEnum;
import com.hubu.service.FoodService;
import com.hubu.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class FoodController {
    @Autowired
    private FoodService fc;

    @RequestMapping("/findfood")
    @ResponseBody
    public Response findallfood(int page){
        return Response.response(ResponseEnum.Success).add("list",fc.findFoodByPage(page,5));
    }
    @RequestMapping("/findfoodbycat")
    @ResponseBody
    public Response findfoodbyid(int page,String category){
        return Response.response(ResponseEnum.Success).add("list",fc.findFoodByCat(page,5,category));
    }
}
