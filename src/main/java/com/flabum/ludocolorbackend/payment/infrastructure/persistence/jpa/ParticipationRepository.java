package com.flabum.ludocolorbackend.payment.infrastructure.persistence.jpa;

import com.flabum.ludocolorbackend.payment.domain.model.entities.Participation;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipationRepository extends JpaRepository<Participation, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Participation p SET p.employee = NULL WHERE p.employee.id = :employeeId")
    void setEmployeeIdNull(@Param("employeeId") Long employeeId);

}
