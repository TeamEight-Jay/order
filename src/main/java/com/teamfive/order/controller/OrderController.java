package com.teamfive.order.controller;

import com.teamfive.order.dto.MerchantDTO;
import com.teamfive.order.dto.OrderDTO;
import com.teamfive.order.dto.ProductDTO;
import com.teamfive.order.entity.Order;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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

        order.setProduct(productDTO);

        setupOrder(order);
        return null;
    }
    //TODO (Sachin)
    private ProductDTO getProduct(String productId) {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "http://localhost:8080/product/get/"+productId;
        ResponseEntity<ProductDTO> response
                = restTemplate.getForEntity(fooResourceUrl , ProductDTO.class);
        return response.getBody();
    }
    // TODO (Dipali)
    private MerchantDTO getMerchant(String merchantId)
    {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "http://localhost:8080/getMerchant/"+merchantId;
        ResponseEntity<MerchantDTO> response
                = restTemplate.getForEntity(fooResourceUrl , MerchantDTO.class);
        return response.getBody();
    }
    private void setupOrder(Order order)
    {
        order.setDate(new Date());
        order.setOrderRating(-1);
        order.setStatus("INITIALIZED");
    }

}
