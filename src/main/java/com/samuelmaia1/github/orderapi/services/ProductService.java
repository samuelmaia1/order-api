package com.samuelmaia1.github.orderapi.services;

import com.samuelmaia1.github.orderapi.dto.RequestProductDto;
import com.samuelmaia1.github.orderapi.dto.ResponseProductDto;
import com.samuelmaia1.github.orderapi.mappers.ProductMapper;
import com.samuelmaia1.github.orderapi.model.Product;
import com.samuelmaia1.github.orderapi.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repository;

    private final ProductMapper productMapper;

    public ProductService(ProductRepository repository, ProductMapper productMapper) {
        this.productMapper = productMapper;
        this.repository = repository;
    }

    public ResponseProductDto addProduct(RequestProductDto dto) {
        Product product = repository.save(new Product(dto));
        return productMapper.toDto(product);
    }

    public List<ResponseProductDto> getAllProducts() {
        return repository
                .findAll()
                .stream()
                .map(product -> productMapper.toDto(product))
                .toList();
    }

}
