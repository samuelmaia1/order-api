package com.samuelmaia1.github.orderapi.mappers;

import com.samuelmaia1.github.orderapi.dto.ResponseOrderDto;
import com.samuelmaia1.github.orderapi.interfaces.Mapper;
import com.samuelmaia1.github.orderapi.model.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderMapper implements Mapper<Order, ResponseOrderDto> {
    private final OrderItemMapper orderItemMapper;

    public OrderMapper(OrderItemMapper orderItemMapper) {
        this.orderItemMapper = orderItemMapper;
    }

    public ResponseOrderDto toDto(Order order){
        return new ResponseOrderDto(
                order.getId(),
                order.getProducts()
                        .stream()
                        .map(orderItem -> orderItemMapper.toDto(orderItem))
                        .toList(),
                order.getTime(),
                order.getTotal(),
                order.getDeliveryType(),
                order.getStatus()
        );
    }

}
