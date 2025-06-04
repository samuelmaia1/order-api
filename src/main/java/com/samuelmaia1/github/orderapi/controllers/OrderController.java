package com.samuelmaia1.github.orderapi.controllers;

import com.samuelmaia1.github.orderapi.dto.RequestOrderDto;
import com.samuelmaia1.github.orderapi.dto.ResponseOrderDto;
import com.samuelmaia1.github.orderapi.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ResponseOrderDto> createOrder(@RequestBody RequestOrderDto dto) {
        return ResponseEntity.ok().body(service.createOrder(dto));
    }

    @GetMapping
    public ResponseEntity<Page<ResponseOrderDto>> getAllOrders(
            @RequestParam(required = false) Boolean orderByTime,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size
    ) {
        return ResponseEntity.ok().body(service.getAll(page, size, orderByTime));
    }
}