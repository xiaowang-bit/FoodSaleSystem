package com.hubu.model;

import java.math.BigDecimal;

public class CartItem {
    private Food food;  //商品
    private int count;	//商品数量

    /**
     * 小计方法：处理二进制运算误差问题
     * @return
     */
    public double getSubtotal(){  //计算方法，没有对应成员

        //将double转化为BigDecimal类型：解决二进制运算误差问题
        BigDecimal _price = BigDecimal.valueOf(food.getPrice());
        BigDecimal _count = BigDecimal.valueOf(count);

        //计算价格（价钱*数量）,并转回double类型
        return _price.multiply(_count).doubleValue();
    }


    public Food getFood() {
        return food;
    }
    public void setFood(Food food) {
        this.food = food;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }

}
