package com.kate.assignment.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kate.assignment.models.dtos.OrderRequest;
import com.kate.assignment.models.dtos.OrderWithDiscounts;
import com.kate.assignment.services.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    public final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/getOrderWithDiscounts")
    public OrderWithDiscounts getOrderWithDiscounts(@RequestBody List<OrderRequest> orderRequests) {
        return orderService.getOrderWithDiscounts(orderRequests);
    }

}
