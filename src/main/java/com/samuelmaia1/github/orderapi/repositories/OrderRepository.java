package com.samuelmaia1.github.orderapi.repositories;

import com.samuelmaia1.github.orderapi.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
}
