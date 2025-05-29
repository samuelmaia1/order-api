package com.samuelmaia1.github.orderapi.dto;

import com.samuelmaia1.github.orderapi.enums.DeliveryType;
import com.samuelmaia1.github.orderapi.enums.OrderStatus;

import java.util.List;

public class RequestOrderDto {
    private List<RequestOrderItemDto> products;
    private DeliveryType deliveryType;
    private OrderStatus status;

    public RequestOrderDto() {}

    public List<RequestOrderItemDto> getProducts() {
        return products;
    }

    public void setProducts(List<RequestOrderItemDto> products) {
        this.products = products;
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
