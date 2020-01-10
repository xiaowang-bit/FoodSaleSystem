package com.hubu.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hubu.mapper.OrderMapper;
import com.hubu.model.Food;
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
    public PageInfo<OrderInfo> queryOrderById(int page,int size,String id) {
        PageHelper.startPage(page,size);
        List<OrderInfo> list=om.queryOrderById(id);
        PageInfo<OrderInfo> pageinf= new PageInfo<>(list);
        return pageinf;
    }

    @Override
    public List<OrderInfo> payOrder(String id) {
        return om.payOrder(id);
    }
}
