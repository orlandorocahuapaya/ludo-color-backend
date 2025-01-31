package com.flabum.ludocolorbackend.employee.application.internal.queryservices;

import com.flabum.ludocolorbackend.employee.domain.model.aggregates.Employee;
import com.flabum.ludocolorbackend.employee.domain.model.queries.GetAllEmployeeQuery;
import com.flabum.ludocolorbackend.employee.domain.model.queries.GetEmployeeByIdQuery;
import com.flabum.ludocolorbackend.employee.domain.service.EmployeeQueryService;
import com.flabum.ludocolorbackend.employee.infrastructure.persistence.jpa.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class EmployeeQueryServiceImpl implements EmployeeQueryService {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> execute( GetAllEmployeeQuery query ) {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> execute(GetEmployeeByIdQuery query) {
        return employeeRepository.findById(query.id());
    }
}
