package com.samuelmaia1.github.orderapi.controllers;

import com.samuelmaia1.github.orderapi.dto.RequestProductDto;
import com.samuelmaia1.github.orderapi.dto.ResponseProductDto;
import com.samuelmaia1.github.orderapi.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService service;

    @PostMapping
    public ResponseEntity<ResponseProductDto> addProduct(@RequestBody RequestProductDto data) {
        System.out.println(data.getName());
        System.out.println(data.getCategory());
        return ResponseEntity.status(201).body(service.addProduct(data));
    }

    @GetMapping
    public ResponseEntity<List<ResponseProductDto>> getAllProducts() {
        return ResponseEntity.status(200).body(service.getAllProducts());
    }
}
