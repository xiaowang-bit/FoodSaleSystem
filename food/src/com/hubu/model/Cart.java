package com.hubu.model;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 购物车类
 * @author 一万年行不行
 *
 */
public class Cart {
    /*
     * map创建：
     * 1.创建Map存放条目，以书id做键<书id,条目>
     * 2.创建LinkedHashMap，为了保证顺序
     */
    private Map<String,CartItem> map = new LinkedHashMap<String, CartItem>();



    /**
     * 合计  （所有条目价钱小计之和）
     * 使用BigDecimal类型：解决二进制运算误差问题
     * @return
     */
    public double getTotal() {
        //使用BigDecimal类型
        BigDecimal total = BigDecimal.valueOf(0);
        //遍历每个条目
        for (CartItem cartItem : map.values()) {
            //得到每个条目价钱（得到BigDecimal类型）
            BigDecimal subTatal = BigDecimal.valueOf(cartItem.getSubtotal());
            //对每个条目进行加法求和
            total = total.add(subTatal);
        }
        return total.doubleValue();	//转为double类型
    }


    /**
     * 添加条目
     * @param cartItem
     */
    public void add(CartItem cartItem){
        /*
         * 1.判断map中是否含有被添加条目
         * 2.有，进行条目合并（合并数量）
         * 	   条目合并：
         * 		1.拿到原条目
         * 		2.条目数量合并 （原数量 + 新数量）
         * 		3.将合并后的条目放进map
         * 3.没有，直接添加
         */
        if(map.containsKey(String.valueOf(cartItem.getFood().getId()))){
            //1.拿到原条目
            CartItem _cartItem = map.get(String.valueOf(cartItem.getFood().getId()));
            //2.条目数量合并 （原数量 + 新数量）
            _cartItem.setCount(_cartItem.getCount() + cartItem.getCount());
            //3.将合并后的条目放进map
            map.put(String.valueOf(cartItem.getFood().getId()), _cartItem);
        }else{
            //直接存放
            map.put(String.valueOf(cartItem.getFood().getId()),cartItem);
        }
    }

    /**
     * 删除指定条目
     * @param id
     */
    public void delete(String id){
        map.remove(id);
    }

    /**
     * 清空条目
     */
    public void clear(){
        map.clear();
    }

    /**
     * 我的购物车（获取所有条目）
     * @return
     */
    public Collection<CartItem> getCartItems(){
        return map.values();
    }

}

/**
 * 购物条目
 * @author 一万年行不行
 *
 */
