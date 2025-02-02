package com.flabum.ludocolorbackend.payment.infrastructure.persistence.jpa;

import com.flabum.ludocolorbackend.payment.domain.model.aggregates.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
