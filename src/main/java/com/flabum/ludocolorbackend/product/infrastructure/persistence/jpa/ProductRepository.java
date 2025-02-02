package com.flabum.ludocolorbackend.product.infrastructure.persistence.jpa;

import com.flabum.ludocolorbackend.clients.domain.model.aggregates.Client;
import com.flabum.ludocolorbackend.product.domain.model.aggregates.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    boolean existsByName(String name);

    List<Product> findAll();
}