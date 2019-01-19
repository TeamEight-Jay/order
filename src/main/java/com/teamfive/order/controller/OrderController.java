package com.teamfive.order.controller;

import com.teamfive.order.dto.OrderDTO;
import com.teamfive.order.entity.Order;
import com.teamfive.order.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;


    @RequestMapping(value = "/order/add", method = RequestMethod.POST)
    public void addOrder(OrderDTO orderDTO)
    {
        Order order= new Order();
        BeanUtils.copyProperties(orderDTO,order);
        setupOrder(order);
        orderService.addOrder(order);
    }
    //TODO (Sachin)
    private boolean getProduct(String productId) {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "http://localhost:8080/product/check/"+productId;
        ResponseEntity<Boolean> response
                = restTemplate.getForEntity(fooResourceUrl , Boolean.class);
        return response.getBody();
    }
    // TODO (Dipali)
    private boolean getMerchant(String merchantId)
    {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "http://localhost:8080/checkMerchant/"+merchantId;
        ResponseEntity<Boolean> response
                = restTemplate.getForEntity(fooResourceUrl , Boolean.class);
        return response.getBody();
    }
    private void setupOrder(Order order)
    {
        order.setDate(new Date());
        order.setOrderRating(-1);
        order.setStatus("INITIALIZED");
    }

}
