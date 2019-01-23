package com.teamfive.order.repository;

import com.teamfive.order.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface OrderRepository extends CrudRepository<Order,String> {

    public ArrayList<Order> findByCustomerId(String customerId);
}
