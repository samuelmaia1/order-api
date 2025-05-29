package com.samuelmaia1.github.orderapi.model;

import com.samuelmaia1.github.orderapi.dto.RequestOrderItemDto;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Product product;

    private Integer quantity;

    private BigDecimal unitValue;

    @Column(name = "observation", length = 300, nullable = true)
    private String observation;

    public OrderItem() {}

    public OrderItem(Order order, Product product, Integer quantity, String observation) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.unitValue = product.getPrice();
        this.observation = observation;
    }

    public String getId() {
        return id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
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

    public BigDecimal getSubTotal() {
        return unitValue.multiply(BigDecimal.valueOf(quantity));
    }
}
