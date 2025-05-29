package com.samuelmaia1.github.orderapi.repositories;

import com.samuelmaia1.github.orderapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
