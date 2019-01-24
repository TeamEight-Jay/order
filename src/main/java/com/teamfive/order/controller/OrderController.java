package com.teamfive.order.controller;

import com.teamfive.order.dto.InventoryDTO;
import com.teamfive.order.dto.OrderDTO;
import com.teamfive.order.dto.OrderResponseDto;
import com.teamfive.order.dto.fullOrderDTO;
import com.teamfive.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    private final String INVENTORY_ENDPOINT="http://10.177.7.88:10000/inventory/";


    @PostMapping(value = "order/new")
    private OrderResponseDto setupOrder(@RequestBody OrderDTO orderDTO)
    {

        //Check with inventory
        RestTemplate inventoryAPI=new RestTemplate();
        InventoryDTO inventoryResponse=inventoryAPI.getForObject(
                INVENTORY_ENDPOINT+"/get/"+orderDTO.getInventoryId(),
                InventoryDTO.class
        );

        if(inventoryResponse==null || inventoryResponse.getProductId()==null || inventoryResponse.getMerchantId()==null ||
        inventoryResponse.getQuantityLeft()==null || inventoryResponse.getPrice()==null)
        {
            OrderResponseDto orderResponseDto=new OrderResponseDto();
            orderResponseDto.setStatus("ERROR");
            orderResponseDto.setMessage("MALFORMED ORDER : "+orderDTO.toString());
            orderResponseDto.setOrder(null);
            return orderResponseDto;
        }
        else
        {
            if(inventoryResponse.getQuantityLeft()<orderDTO.getQuantity())
            {
                OrderResponseDto orderResponseDto=new OrderResponseDto();
                orderResponseDto.setStatus("FAILURE");
                orderResponseDto.setMessage("REQUESTED QUANTITY NOT AVAILABLE, CURRENT QUANTITY : "+inventoryResponse.getQuantityLeft());
                orderResponseDto.setOrder(null);
                return orderResponseDto;
            }

            fullOrderDTO fullOrderDTO=new fullOrderDTO();

            fullOrderDTO.setProductId(inventoryResponse.getProductId());
            fullOrderDTO.setMerchantId(inventoryResponse.getMerchantId());
            fullOrderDTO.setInventoryId(orderDTO.getInventoryId());
            fullOrderDTO.setCustomerId(orderDTO.getCustomerId());
            fullOrderDTO.setPrice(inventoryResponse.getPrice());
            fullOrderDTO.setAddress(orderDTO.getAddress());
            fullOrderDTO.setQuantity(orderDTO.getQuantity());
            fullOrderDTO.setModeOfPayment("CASH_ON_DELIVERY");

            String inventoryOrderResponse= inventoryAPI.getForObject(INVENTORY_ENDPOINT+"/placeorder/"
                    +fullOrderDTO.getInventoryId()+"/"
                    +fullOrderDTO.getQuantity(),String.class);

            OrderResponseDto orderResponseDto=new OrderResponseDto();

            if(inventoryOrderResponse.equals("SUCCESS")) {
                fullOrderDTO = orderService.initOrder(fullOrderDTO);
                orderResponseDto.setStatus("INITIALIZED");
                orderResponseDto.setOrder(fullOrderDTO);
            }
            else{
                orderResponseDto.setStatus("FAILURE");
            }


            orderResponseDto.setMessage(inventoryOrderResponse);




            return orderResponseDto;


        }


    }

    @GetMapping("/order/customer/get/{customerId}")
    public ArrayList<fullOrderDTO> getAllOrders(@PathVariable String customerId)
    {
        return orderService.getAllOrders(customerId);
    }

}
