package com.flabum.ludocolorbackend.employee.interfaces.rest;

import com.flabum.ludocolorbackend.employee.domain.model.aggregates.Employee;
import com.flabum.ludocolorbackend.employee.domain.model.commands.AddEmployeeCommand;
import com.flabum.ludocolorbackend.employee.domain.model.commands.DeleteEmployeeByIdCommand;
import com.flabum.ludocolorbackend.employee.domain.model.queries.GetAllEmployeeQuery;
import com.flabum.ludocolorbackend.employee.domain.model.queries.GetEmployeeByIdQuery;
import com.flabum.ludocolorbackend.employee.domain.service.EmployeeCommandService;
import com.flabum.ludocolorbackend.employee.domain.service.EmployeeQueryService;
import com.flabum.ludocolorbackend.employee.interfaces.rest.resources.AddEmployeeCommandResource;
import com.flabum.ludocolorbackend.employee.interfaces.rest.resources.EmployeeResource;
import com.flabum.ludocolorbackend.employee.interfaces.rest.resources.UpdateEmployeeCommandResource;
import com.flabum.ludocolorbackend.employee.interfaces.rest.transform.AddEmployeeCommandFromResourceAssembler;
import com.flabum.ludocolorbackend.employee.interfaces.rest.transform.EmployeeResourceFromEntityAssembler;
import com.flabum.ludocolorbackend.employee.interfaces.rest.transform.UpdateEmployeeCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "api/v1/employee", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name="Employee", description = "Employee Management Endpoints")
public class EmployeeController {

    public final EmployeeCommandService employeeCommandService;
    public final EmployeeQueryService employeeQueryService;

    @GetMapping()
    public ResponseEntity<List<EmployeeResource>> getAllEmployee() {
        var getAllEmployeeQuery = new GetAllEmployeeQuery();
        var employees = employeeQueryService.execute(getAllEmployeeQuery);
        var employeesResource = employees.stream().map(employee -> new EmployeeResource(employee.getId(), employee.getName(), employee.getPhone())).toList();
        return ResponseEntity.ok(employeesResource);
    }

    @GetMapping("get-employee")
    public ResponseEntity<EmployeeResource> getAllEmployee(@RequestParam("id") Long id) {
        var getEmployeeByIdQuery = new GetEmployeeByIdQuery(id);
        var employee = employeeQueryService.execute(getEmployeeByIdQuery);
        var employeeResource = EmployeeResourceFromEntityAssembler.toResourceFromEntity(employee.get());
        return ResponseEntity.ok(employeeResource);
    }

    @PostMapping("add-employee")
    public ResponseEntity<EmployeeResource> addEmployee(@RequestBody AddEmployeeCommandResource resource) {
        var addEmployeeCommand = AddEmployeeCommandFromResourceAssembler.toCommandFromResource(resource);
        var employee = employeeCommandService.execute(addEmployeeCommand);
        var employeeResource = EmployeeResourceFromEntityAssembler.toResourceFromEntity(employee.get());
        return ResponseEntity.ok(employeeResource);
    }

    @DeleteMapping("delete-employee")
    public ResponseEntity<Boolean> deleteEmployee(@RequestParam("id") Long id) {
        var deleteEmployeByIdCommand = new DeleteEmployeeByIdCommand(id);
        var isEmployeeDeleted = employeeCommandService.execute(deleteEmployeByIdCommand);
        return ResponseEntity.ok(isEmployeeDeleted);
    }

    @PutMapping("update-employee")
    public ResponseEntity<EmployeeResource> updateEmployee(@RequestBody UpdateEmployeeCommandResource resource) {
        var updateEmployeeCommand = UpdateEmployeeCommandFromResourceAssembler.toCommandFromResource(resource);
        var employee = employeeCommandService.execute(updateEmployeeCommand);
        var employeeResource = EmployeeResourceFromEntityAssembler.toResourceFromEntity(employee.get());
        return ResponseEntity.ok(employeeResource);
    }

}
