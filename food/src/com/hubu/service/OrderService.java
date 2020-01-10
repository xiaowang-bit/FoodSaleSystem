package com.hubu.service;

import com.hubu.model.OrderInfo;

import java.util.List;

public interface OrderService {
    public int addOrder(OrderInfo order);

    public List<OrderInfo> queryOrderById(String id);

    public List<OrderInfo> payOrder(String id);
}
