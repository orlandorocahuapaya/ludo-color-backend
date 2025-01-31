package com.flabum.ludocolorbackend.product.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String productSet;

    private Double price;

    public Product(String name, String brand, String productSet, Double price) {
        this.name = name;
        this.brand = brand;
        this.productSet = productSet;
        this.price = price;
    }
}
