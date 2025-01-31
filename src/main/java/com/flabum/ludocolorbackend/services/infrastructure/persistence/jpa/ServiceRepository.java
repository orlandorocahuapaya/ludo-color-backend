package com.flabum.ludocolorbackend.services.infrastructure.persistence.jpa;

import com.flabum.ludocolorbackend.product.domain.model.aggregates.Product;
import com.flabum.ludocolorbackend.services.domain.model.aggregates.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {

    boolean existsByName(String name);

    List<Service> findAll();

    @Query("SELECT COUNT(s) FROM Service s WHERE s.name = :name")
    long countByName(@Param("name") String name);

}
