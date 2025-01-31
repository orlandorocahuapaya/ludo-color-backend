package com.flabum.ludocolorbackend.employee.domain.service;

import com.flabum.ludocolorbackend.clients.domain.model.commands.AddClientCommnad;
import com.flabum.ludocolorbackend.clients.domain.model.commands.DeleteClientByIdCommand;
import com.flabum.ludocolorbackend.clients.domain.model.commands.UpdateClientCommand;
import com.flabum.ludocolorbackend.employee.domain.model.aggregates.Employee;
import com.flabum.ludocolorbackend.employee.domain.model.commands.AddEmployeeCommand;
import com.flabum.ludocolorbackend.employee.domain.model.commands.DeleteEmployeeByIdCommand;
import com.flabum.ludocolorbackend.employee.domain.model.commands.UpdateEmployeeCommand;

import java.util.Optional;

public interface EmployeeCommandService {

    Optional<Employee> execute(AddEmployeeCommand commnad);

    boolean execute(DeleteEmployeeByIdCommand commnad);

    Optional<Employee> execute(UpdateEmployeeCommand commnad);

}
