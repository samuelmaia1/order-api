package com.samuelmaia1.github.orderapi.model;

import com.samuelmaia1.github.orderapi.dto.RequestOrderDto;
import com.samuelmaia1.github.orderapi.enums.DeliveryType;
import com.samuelmaia1.github.orderapi.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "orders")
@Entity
@Data
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Column(name = "order_time", nullable = false)
    private LocalDateTime time;

    @Column(name = "total", nullable = false, precision = 18, scale = 2)
    private BigDecimal total;

    @Column(name = "delivery_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private DeliveryType deliveryType;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> products = new ArrayList<>();

    public Order() {}

    public Order(RequestOrderDto dto) {
        this.deliveryType = dto.getDeliveryType();
        this.status = dto.getStatus();
        this.time = LocalDateTime.now();
    }

    public BigDecimal getTotalPrice() {
        return products
                .stream()
                .map(OrderItem::getSubTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}