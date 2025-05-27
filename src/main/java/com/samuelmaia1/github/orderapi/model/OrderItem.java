package com.samuelmaia1.github.orderapi.model;

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

    public BigDecimal getSubTotal() {
        return unitValue.multiply(BigDecimal.valueOf(quantity));
    }
}
