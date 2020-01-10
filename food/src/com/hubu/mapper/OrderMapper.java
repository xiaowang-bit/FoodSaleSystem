package com.hubu.mapper;

import com.hubu.model.OrderInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {
    public int addOrder(OrderInfo order);

    public List<OrderInfo> queryOrderById(String id);

    public List<OrderInfo> payOrder(String id);
}
