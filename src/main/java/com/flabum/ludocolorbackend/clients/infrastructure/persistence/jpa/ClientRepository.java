package com.flabum.ludocolorbackend.clients.infrastructure.persistence.jpa;

import com.flabum.ludocolorbackend.clients.domain.model.aggregates.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    boolean existsByName(String name);

    List<Client> findAll();

}
