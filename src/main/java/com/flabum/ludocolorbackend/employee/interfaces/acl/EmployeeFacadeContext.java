package com.flabum.ludocolorbackend.employee.interfaces.acl;

import com.flabum.ludocolorbackend.employee.application.internal.commandservices.EmployeeCommandServiceImpl;
import com.flabum.ludocolorbackend.employee.domain.model.aggregates.Employee;
import com.flabum.ludocolorbackend.employee.domain.model.queries.GetEmployeeByIdQuery;
import com.flabum.ludocolorbackend.employee.domain.service.EmployeeCommandService;
import com.flabum.ludocolorbackend.employee.domain.service.EmployeeQueryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class EmployeeFacadeContext {

    private final EmployeeCommandService employeeCommandService;
    private final EmployeeQueryService employeeQueryService;

    public Optional<Employee> getEmployeeById(Long id) {
        var getEmployeeByIdQuery = new GetEmployeeByIdQuery(id);
        return employeeQueryService.execute(getEmployeeByIdQuery);
    }

}
