package com.flabum.ludocolorbackend.employee.domain.service;

import com.flabum.ludocolorbackend.employee.domain.model.aggregates.Employee;
import com.flabum.ludocolorbackend.employee.domain.model.queries.GetAllEmployeeQuery;
import com.flabum.ludocolorbackend.employee.domain.model.queries.GetEmployeeByIdQuery;

import java.util.List;
import java.util.Optional;

public interface EmployeeQueryService {

    List<Employee> execute(GetAllEmployeeQuery query);

    Optional<Employee> execute(GetEmployeeByIdQuery query);

}
