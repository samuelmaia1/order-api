package com.samuelmaia1.github.orderapi.model;

import com.samuelmaia1.github.orderapi.dto.RequestProductDto;
import com.samuelmaia1.github.orderapi.dto.ResponseProductDto;
import com.samuelmaia1.github.orderapi.enums.ProductCategory;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "name",length = 200, nullable = false)
    private String name;

    @Column(name = "price", precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "description", length = 300, nullable = true)
    private String description;

    @Column(name = "category", nullable = false, length = 30)
    @Enumerated(EnumType.STRING)
    private ProductCategory category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orders = new ArrayList<>();

    public Product() {}

    public Product(RequestProductDto dto){
        this.name = dto.getName();
        this.price = dto.getPrice();
        this.description = dto.getDescription();
        this.category = dto.getCategory();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<OrderItem> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderItem> orders) {
        this.orders = orders;
    }

    public ResponseProductDto toDto() {
        return new ResponseProductDto(this.id, this.name, this.description, this.price);
    }
}
