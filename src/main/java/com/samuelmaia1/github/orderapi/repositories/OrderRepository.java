package com.samuelmaia1.github.orderapi.repositories;

import com.samuelmaia1.github.orderapi.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, String> {
    List<Order> findAllByOrderByTimeDesc();
}
