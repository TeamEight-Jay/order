package com.teamfive.order.service;

import com.teamfive.order.entity.Order;
import com.teamfive.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public void addOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public Order selectOrder(String orderId) {
        return orderRepository.findOne(orderId);
    }

}
