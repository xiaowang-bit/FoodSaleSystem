package com.hubu.service;

import com.github.pagehelper.PageInfo;
import com.hubu.model.OrderInfo;

import java.util.List;

public interface OrderService {
    public int addOrder(OrderInfo order);

    public PageInfo<OrderInfo> queryOrderById(int page, int size, String id);

    public List<OrderInfo> payOrder(String id);
}
