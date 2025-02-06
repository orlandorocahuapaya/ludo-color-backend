package com.flabum.ludocolorbackend.payment.infrastructure.persistence.jpa;

import com.flabum.ludocolorbackend.payment.domain.model.aggregates.Sale;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Sale s SET s.client = NULL WHERE s.client.id = :clientId")
    void setClientIdNull(@Param("clientId") Long clientId);

}
