package com.hubu.service.Impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hubu.mapper.FoodMapper;
import com.hubu.model.Food;
import com.hubu.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {
    @Autowired
    private FoodMapper fm;
    public Food queryfoodbyId(String id){
        return fm.queryfoodbyId(id);
    }

    @Override
    public List<Food> findAllFood() {
        return fm.findAllFood();
    }

    @Override
    public PageInfo<Food> findFoodByPage(int page, int pageSize) {
        PageHelper.startPage(page,pageSize);
        List<Food> list=fm.findAllFood();
        PageInfo<Food> pageinf= new PageInfo<>(list);
        return pageinf;
    }

    @Override
    public PageInfo<Food> findFoodByCat(int page,int pageSize, String category) {
        PageHelper.startPage(page,pageSize);
        List<Food> list=fm.findFoodByCat(category);
        PageInfo<Food> pageinf= new PageInfo<>(list);
        return pageinf;
    }
}
