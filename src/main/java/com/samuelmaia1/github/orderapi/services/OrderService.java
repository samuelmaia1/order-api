package com.samuelmaia1.github.orderapi.services;

import com.samuelmaia1.github.orderapi.dto.RequestOrderDto;
import com.samuelmaia1.github.orderapi.dto.RequestOrderItemDto;
import com.samuelmaia1.github.orderapi.exceptions.OrderIsEmptyException;
import com.samuelmaia1.github.orderapi.model.Order;
import com.samuelmaia1.github.orderapi.model.OrderItem;
import com.samuelmaia1.github.orderapi.model.Product;
import com.samuelmaia1.github.orderapi.repositories.OrderRepository;
import com.samuelmaia1.github.orderapi.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    public Order createOrder(RequestOrderDto data) {
        if (data.getProducts() == null || data.getProducts().isEmpty())
            throw new OrderIsEmptyException("O pedido deve ter ao menos 1 item.");

        Order order = new Order(data);

        List<OrderItem> items = new ArrayList<>();

        for (RequestOrderItemDto item : data.getProducts()) {
            Product product = productRepository
                    .findById(item.getProductId())
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado."));

            OrderItem orderItem = new OrderItem(order, product, item.getQuantity(), item.getObservation());
            items.add(orderItem);
        }

        order.setProducts(items);
        order.setTotal(order.getTotalPrice());

        return orderRepository.save(order);
    }
}
