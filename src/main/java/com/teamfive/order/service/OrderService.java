package com.teamfive.order.service;

import com.teamfive.order.entity.Order;

public interface OrderService {
    public void addOrder(Order order);
    public Order selectOrder(String orderId);
}
