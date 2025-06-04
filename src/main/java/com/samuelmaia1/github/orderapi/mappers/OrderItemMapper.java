package com.samuelmaia1.github.orderapi.mappers;

import com.samuelmaia1.github.orderapi.dto.ResponseOrderItemDto;
import com.samuelmaia1.github.orderapi.interfaces.Mapper;
import com.samuelmaia1.github.orderapi.model.OrderItem;
import org.springframework.stereotype.Service;

@Service
public class OrderItemMapper implements Mapper<OrderItem, ResponseOrderItemDto> {
    private final ProductMapper productMapper;

    public OrderItemMapper(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    public ResponseOrderItemDto toDto(OrderItem orderItem) {
        return new ResponseOrderItemDto(
                orderItem.getId(),
                productMapper.toDto(orderItem.getProduct()),
                orderItem.getQuantity(),
                orderItem.getUnitValue(),
                orderItem.getObservation()
        );
    }
}
