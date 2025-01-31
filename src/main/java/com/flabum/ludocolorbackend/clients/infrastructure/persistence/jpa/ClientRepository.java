package com.flabum.ludocolorbackend.clients.infrastructure.persistence.jpa;

import com.flabum.ludocolorbackend.clients.domain.model.aggregates.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    boolean existsByName(String name);

    List<Client> findAll();

    @Query("SELECT COUNT(c) FROM Client c WHERE c.name = :name")
    long countByName(@Param("name") String name);
}
