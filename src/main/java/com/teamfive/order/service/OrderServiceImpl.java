package com.teamfive.order.service;

import com.teamfive.order.dto.OrderDTO;
import com.teamfive.order.dto.fullOrderDTO;
import com.teamfive.order.dto.ratingUpdateKafkaMessage;
import com.teamfive.order.entity.Order;
import com.teamfive.order.repository.OrderRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Order selectOrder(String orderId) {
        return orderRepository.findOne(orderId);
    }

    @Override
    public fullOrderDTO initOrder(fullOrderDTO orderDTO) {

        Order order=new Order();

        BeanUtils.copyProperties(orderDTO,order);

        order.setOrderRating(-1);
        order.setStatus("INITIALIZED");
        order.setDate((new Date()));
        order=orderRepository.save(order);

        BeanUtils.copyProperties(order,orderDTO);
        return orderDTO;

    }

    @Override
    public ArrayList<fullOrderDTO> getAllOrders(String customerID) {
        ArrayList<Order> orderArrayList=orderRepository.findByCustomerId(customerID);
        ArrayList<fullOrderDTO> fullOrderDTOArrayList=new ArrayList<fullOrderDTO>();
        for(Order order:orderArrayList)
        {
            fullOrderDTO fullOrderDTO=new fullOrderDTO();
            BeanUtils.copyProperties(order,fullOrderDTO);
            fullOrderDTOArrayList.add(fullOrderDTO);
        }
        return fullOrderDTOArrayList;
    }

    @Override
    public void rateOrder(String orderId,double rating) {
        Order order = orderRepository.findOne(orderId);
        if(order.getOrderRating()>=0&&order.getOrderRating()<=5) return;
        if(rating<0||rating>5) return;
        order.setOrderRating(rating);

    }

}
