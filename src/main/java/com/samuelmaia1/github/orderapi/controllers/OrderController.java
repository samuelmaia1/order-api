package com.samuelmaia1.github.orderapi.controllers;

import com.samuelmaia1.github.orderapi.dto.RequestOrderDto;
import com.samuelmaia1.github.orderapi.model.Order;
import com.samuelmaia1.github.orderapi.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService service;

    public ResponseEntity<Order> createOrder(@RequestBody RequestOrderDto dto) {
        return ResponseEntity.ok().body(service.createOrder(dto));
    }
}
