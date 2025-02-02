package com.flabum.ludocolorbackend.payment.infrastructure.persistence.jpa;

import com.flabum.ludocolorbackend.payment.domain.model.aggregates.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
}
