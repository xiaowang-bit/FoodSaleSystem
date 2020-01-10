package com.hubu.service;

import com.github.pagehelper.PageInfo;
import com.hubu.model.Food;

import java.util.List;

public interface FoodService {
    public Food queryfoodbyId(String id);

    public List<Food> findAllFood();

    public PageInfo<Food> findFoodByPage(int page, int size);

    public PageInfo<Food> findFoodByCat(int page, int pageSize, String category);
}
