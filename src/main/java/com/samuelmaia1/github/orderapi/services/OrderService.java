package com.samuelmaia1.github.orderapi.services;

import com.samuelmaia1.github.orderapi.dto.RequestOrderDto;
import com.samuelmaia1.github.orderapi.dto.RequestOrderItemDto;
import com.samuelmaia1.github.orderapi.dto.ResponseOrderDto;
import com.samuelmaia1.github.orderapi.exceptions.OrderIsEmptyException;
import com.samuelmaia1.github.orderapi.mappers.OrderMapper;
import com.samuelmaia1.github.orderapi.model.Order;
import com.samuelmaia1.github.orderapi.model.OrderItem;
import com.samuelmaia1.github.orderapi.model.Product;
import com.samuelmaia1.github.orderapi.repositories.OrderRepository;
import com.samuelmaia1.github.orderapi.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    private final ProductRepository productRepository;

    private final OrderMapper orderMapper;

    public OrderService(OrderRepository orderRepository, ProductRepository productRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.orderMapper = orderMapper;
    }

    public ResponseOrderDto createOrder(RequestOrderDto data) {
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

        return orderMapper.toDto(orderRepository.save(order));
    }

    public Page<ResponseOrderDto> getAll(Integer page, Integer size, Boolean orderByTime) {
        Pageable pageable;

        if (Boolean.TRUE.equals(orderByTime))
            pageable = PageRequest.of(page, size, Sort.by("time").descending());
        else
            pageable = PageRequest.of(page, size);

        Page<Order> orders = orderRepository.findAll(pageable);

        return orders.map(order -> orderMapper.toDto(order));
    }
}