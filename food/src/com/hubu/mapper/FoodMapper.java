package com.hubu.mapper;

import com.hubu.model.Food;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodMapper {
    public Food queryfoodbyId(@Param("id") String id);

    public List<Food> findAllFood();

    public List<Food> findFoodByCat(@Param("category") String category);
}
