package com.teamfive.order.repository;

import com.teamfive.order.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface OrderRepository extends CrudRepository<Order,String> {
}
