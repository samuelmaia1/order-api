package com.samuelmaia1.github.orderapi.dto;

import java.math.BigDecimal;

public class ResponseOrderItemDto {
    private String id;
    private ResponseProductDto product;
    private Integer quantity;
    private BigDecimal unitValue;
    private String observation;

    public ResponseOrderItemDto() {}

    public ResponseOrderItemDto(String id, ResponseProductDto product, Integer quantity, BigDecimal unitValue, String observation) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.unitValue = unitValue;
        this.observation = observation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ResponseProductDto getProduct() {
        return product;
    }

    public void setProduct(ResponseProductDto product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitValue() {
        return unitValue;
    }

    public void setUnitValue(BigDecimal unitValue) {
        this.unitValue = unitValue;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }
}
