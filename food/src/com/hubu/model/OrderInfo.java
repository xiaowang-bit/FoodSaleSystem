package com.hubu.model;

/**
 * @author star
 * @date 2020/1/10 10:21
 * @description 订单类
 */
public class OrderInfo {
    private String id;
    private int num;
    private float price;
    private int status;
    private String user_id;

    public OrderInfo(String id, int num, float price, int status, String user_id) {
        this.id = id;
        this.num = num;
        this.price = price;
        this.status = status;
        this.user_id = user_id;
    }

    public OrderInfo() {
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "id='" + id + '\'' +
                ", num=" + num +
                ", price=" + price +
                ", status=" + status +
                ", user_id='" + user_id + '\'' +
                '}';
    }
}
