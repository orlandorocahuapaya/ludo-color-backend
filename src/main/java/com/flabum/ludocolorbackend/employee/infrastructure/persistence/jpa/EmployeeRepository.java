package com.flabum.ludocolorbackend.employee.infrastructure.persistence.jpa;

import com.flabum.ludocolorbackend.employee.domain.model.aggregates.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    boolean existsByName(String name);

    Optional<Employee> findById(Long id);

    @Query("SELECT COUNT(e) FROM Employee e WHERE e.name = :name")
    long countByName(@Param("name") String name);

}
