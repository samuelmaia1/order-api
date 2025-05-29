package com.samuelmaia1.github.orderapi.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class RequestOrderItemDto {
    @NotNull
    private String productId;
    @NotNull @Positive
    private Integer quantity;
    private String observation;

    public RequestOrderItemDto() {
    }

    public @NotNull String getProductId() {
        return productId;
    }

    public void setProductId(@NotNull String productId) {
        this.productId = productId;
    }

    public @NotNull @Positive Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(@NotNull @Positive Integer quantity) {
        this.quantity = quantity;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }
}