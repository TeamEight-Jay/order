package com.teamfive.order.service;

import com.teamfive.order.dto.OrderDTO;
import com.teamfive.order.dto.fullOrderDTO;
import com.teamfive.order.entity.Order;

import java.util.ArrayList;

public interface OrderService {
    public Order selectOrder(String orderId);
    public fullOrderDTO initOrder(fullOrderDTO orderDTO);
    public ArrayList<fullOrderDTO> getAllOrders(String customerID);
    public void rateOrder(String orderId,double rating);
}
