package com.flabum.ludocolorbackend.employee.interfaces.rest.transform;

import com.flabum.ludocolorbackend.employee.domain.model.aggregates.Employee;
import com.flabum.ludocolorbackend.employee.interfaces.rest.resources.EmployeeResource;

public class EmployeeResourceFromEntityAssembler{
    public static EmployeeResource toResourceFromEntity(Employee employee){
        return new EmployeeResource(employee.getId(), employee.getName(), employee.getPhone());
    }
}
