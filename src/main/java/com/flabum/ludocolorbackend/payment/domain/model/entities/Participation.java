package com.flabum.ludocolorbackend.payment.domain.model.entities;

import com.flabum.ludocolorbackend.employee.domain.model.aggregates.Employee;
import com.flabum.ludocolorbackend.payment.domain.model.aggregates.Order;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Data
@Entity
public class Participation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Employee employee;

    private String name;

    @ManyToOne
    @JoinColumn()
    private Order order;

    private Double participationPercentage;

    public Participation() {
    }

    public Participation(Employee employee, Order order, Double participationPercentage) {
        this.employee = employee;
        this.order = order;
        this.participationPercentage = participationPercentage;
        this.name = this.getParticipationName();
    }

    private String getParticipationName(){
        return this.employee.getName();
    }
}
