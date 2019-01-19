package com.teamfive.order.controller;

import com.teamfive.order.dto.MerchantDTO;
import com.teamfive.order.dto.OrderDTO;
import com.teamfive.order.dto.ProductDTO;
import com.teamfive.order.entity.Order;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;

@RestController
public class OrderController {

    @RequestMapping(value = "/order/add", method = RequestMethod.POST)
    public OrderDTO addOrder(OrderDTO orderDTO)
    {
        ProductDTO productDTO= getProduct(orderDTO.getProductId());
        MerchantDTO merchantDTO= getMerchant(orderDTO.getMerchantId());

        Order order= new Order();

        BeanUtils.copyProperties(orderDTO,order);

        order.setProductId(productDTO);

        setupOrder(order);
        return null;
    }
    //TODO (Sachin)
    private ProductDTO getProduct(String productId)
    {
        return null;
    }
    // TODO (Dipali)
    private MerchantDTO getMerchant(String merchantId)
    {
        return null;
    }
    private void setupOrder(Order order)
    {
        order.setDate(new Date());
        order.setOrderRating(-1);
        order.setStatus("INITIALIZED");
    }

}
