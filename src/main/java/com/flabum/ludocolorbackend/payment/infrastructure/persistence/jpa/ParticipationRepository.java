package com.flabum.ludocolorbackend.payment.infrastructure.persistence.jpa;

import com.flabum.ludocolorbackend.payment.domain.model.entities.Participation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipationRepository extends JpaRepository<Participation, Long> {
}
