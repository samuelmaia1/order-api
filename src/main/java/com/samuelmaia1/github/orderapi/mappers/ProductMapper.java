package com.samuelmaia1.github.orderapi.mappers;

import com.samuelmaia1.github.orderapi.dto.ResponseProductDto;
import com.samuelmaia1.github.orderapi.interfaces.Mapper;
import com.samuelmaia1.github.orderapi.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper implements Mapper<Product, ResponseProductDto> {
    public ResponseProductDto toDto(Product product) {
        return new ResponseProductDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice()
        );
    }
}
