package com.samuelmaia1.github.orderapi.dto;

import com.samuelmaia1.github.orderapi.enums.ProductCategory;

import java.math.BigDecimal;

public class RequestProductDto {
    private String name;
    private BigDecimal price;
    private String description;
    private ProductCategory category;

    public RequestProductDto() {}

    public RequestProductDto(String name, BigDecimal price, String description, ProductCategory category) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }
}
