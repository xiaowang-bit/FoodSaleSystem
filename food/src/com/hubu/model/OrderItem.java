package com.hubu.model;

/**
 * @author star
 * @date 2020/1/10 10:24
 * @description 订购某种商品信息表
 */
public class OrderItem {
    private String id;
    private int num;
    private float price;
    private String orderInfo_id;
    private int food_id;

    public OrderItem(String id, int num, float price, String orderInfo_id, int food_id) {
        this.id = id;
        this.num = num;
        this.price = price;
        this.orderInfo_id = orderInfo_id;
        this.food_id = food_id;
    }

    public OrderItem() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getOrderInfo_id() {
        return orderInfo_id;
    }

    public void setOrderInfo_id(String orderInfo_id) {
        this.orderInfo_id = orderInfo_id;
    }

    public int getFood_id() {
        return food_id;
    }

    public void setFood_id(int food_id) {
        this.food_id = food_id;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id='" + id + '\'' +
                ", num=" + num +
                ", price=" + price +
                ", orderInfo_id='" + orderInfo_id + '\'' +
                ", food_id=" + food_id +
                '}';
    }
}
