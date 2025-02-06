package com.flabum.ludocolorbackend.payment.infrastructure.persistence.jpa;

import com.flabum.ludocolorbackend.payment.domain.model.aggregates.Order;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE Order o SET o.service = NULL WHERE o.service.id = :serviceId")
    void setServiceIdNull(@Param("serviceId") Long serviceId);

    @Modifying
    @Transactional
    @Query("UPDATE Order o SET o.product = NULL WHERE o.product.id = :productId")
    void setProductIdNull(@Param("productId") Long productId);
}
