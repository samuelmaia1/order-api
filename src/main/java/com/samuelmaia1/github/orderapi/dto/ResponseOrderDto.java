package com.samuelmaia1.github.orderapi.dto;

import com.samuelmaia1.github.orderapi.enums.DeliveryType;
import com.samuelmaia1.github.orderapi.enums.OrderStatus;
import com.samuelmaia1.github.orderapi.model.OrderItem;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class ResponseOrderDto {
    private String id;
    private List<ResponseOrderItemDto> products;
    private LocalDateTime time;
    private BigDecimal total;
    private DeliveryType deliveryType;
    private OrderStatus status;

    public ResponseOrderDto() {}

    public ResponseOrderDto(String id, List<ResponseOrderItemDto> products, LocalDateTime time, BigDecimal total, DeliveryType deliveryType, OrderStatus status) {
        this.id = id;
        this.products = products;
        this.time = time;
        this.total = total;
        this.deliveryType = deliveryType;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ResponseOrderItemDto> getProducts() {
        return products;
    }

    public void setProducts(List<ResponseOrderItemDto> products) {
        this.products = products;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
