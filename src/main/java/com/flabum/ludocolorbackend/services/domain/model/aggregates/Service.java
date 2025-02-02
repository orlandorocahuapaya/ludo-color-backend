package com.flabum.ludocolorbackend.services.domain.model.aggregates;

import com.flabum.ludocolorbackend.payment.domain.model.aggregates.Order;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

    @OneToMany(mappedBy = "service")
    private List<Order> orders;

    public Service(String name, String serviceType, Double price) {
        this.name = name;
        this.serviceType = serviceType;
        this.price = price;
    }
}
