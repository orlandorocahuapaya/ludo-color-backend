package com.flabum.ludocolorbackend.iam.infrastructure.persistence.jpa.repositories;

import com.flabum.ludocolorbackend.iam.domain.model.aggregates.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByName(String name);

    boolean existsByName(String name);
}
