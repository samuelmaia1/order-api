package com.samuelmaia1.github.orderapi.services;

import com.samuelmaia1.github.orderapi.dto.RequestProductDto;
import com.samuelmaia1.github.orderapi.dto.ResponseProductDto;
import com.samuelmaia1.github.orderapi.model.Product;
import com.samuelmaia1.github.orderapi.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public ResponseProductDto addProduct(RequestProductDto dto) {
        Product product = repository.save(new Product(dto));
        return product.toDto();
    }

    public List<ResponseProductDto> getAllProducts() {
        return repository
                .findAll()
                .stream()
                .map(product -> product.toDto())
                .toList();
    }

}
