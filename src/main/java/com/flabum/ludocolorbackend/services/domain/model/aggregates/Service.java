package com.flabum.ludocolorbackend.services.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(nullable = true)
    private String serviceType;

    private Double price;

    public Service(String name, String serviceType, Double price) {
        this.name = name;
        this.serviceType = serviceType;
        this.price = price;
    }
}
