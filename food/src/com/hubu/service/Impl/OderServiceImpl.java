package com.hubu.service.Impl;

import com.hubu.mapper.OrderMapper;
import com.hubu.model.OrderInfo;
import com.hubu.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class OderServiceImpl implements OrderService {
    @Autowired
    private  OrderMapper om;
    @Override
    public int addOrder(OrderInfo order) {
        return om.addOrder(order);
    }

    @Override
    public List<OrderInfo> queryOrderById(String id) {
        return om.queryOrderById(id);
    }

    @Override
    public List<OrderInfo> payOrder(String id) {
        return om.payOrder(id);
    }
}
