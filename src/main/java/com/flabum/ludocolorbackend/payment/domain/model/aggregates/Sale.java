package com.flabum.ludocolorbackend.payment.domain.model.aggregates;

import com.flabum.ludocolorbackend.clients.domain.model.aggregates.Client;
import com.flabum.ludocolorbackend.payment.domain.model.valueobject.PaymentMethod;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = true)
    private Client client;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders;

    private Date date;

    public Sale() {}

    public Sale(Client client, PaymentMethod paymentMethod, Date date) {
        this.client = client;
        this.paymentMethod = paymentMethod;
        this.date = date;
    }

    public Sale(Client client, PaymentMethod paymentMethod, List<Order> orders, Date date) {
        this.client = client;
        this.paymentMethod = paymentMethod;
        this.orders = orders;
        this.date = date;
    }

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Date createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private Date updateAt;

}
