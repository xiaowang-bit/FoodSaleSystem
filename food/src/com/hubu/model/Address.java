package com.hubu.model;

/**
 * @author star
 * @date 2020/1/10 10:13
 * @description 地址类
 */
public class Address {
    private int id;
    private String address;
    private String user_id;

    public Address(int id, String address, String user_id) {
        this.id = id;
        this.address = address;
        this.user_id = user_id;
    }

    public Address() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", Address='" + address + '\'' +
                ", user_id='" + user_id + '\'' +
                '}';
    }
}
