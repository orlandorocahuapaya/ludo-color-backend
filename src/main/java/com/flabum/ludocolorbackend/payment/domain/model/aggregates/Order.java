package com.flabum.ludocolorbackend.payment.domain.model.aggregates;


import com.flabum.ludocolorbackend.clients.domain.model.aggregates.Client;
import com.flabum.ludocolorbackend.payment.domain.model.entities.Participation;
import com.flabum.ludocolorbackend.product.domain.model.aggregates.Product;
import com.flabum.ludocolorbackend.services.domain.model.aggregates.Service;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Data
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Sale sale;

    @ManyToOne
    @JoinColumn(nullable = true)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private Product product;

    @ManyToOne
    @JoinColumn(nullable = true)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private Service service;

    private String name;

    private Integer amount;

    private Double price;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Participation> participation;

    public Order() {
    }

    public Order(Sale sale, Product product, Service service, Integer amount, Double price) {
        this.sale = sale;
        this.product = product;
        this.service = service;
        this.amount = amount;
        this.price = price;
        this.name = getOrderName();
    }

    private String getOrderName(){
        if (this.product == null){
            return this.service.getName() + " " + this.service.getServiceType();
        }else{
            return this.product.getName() + " " + this.product.getBrand() + " " + this.product.getProductSet();
        }
    }

}
