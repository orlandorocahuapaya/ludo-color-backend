package com.flabum.ludocolorbackend.employee.interfaces.rest.transform;

import com.flabum.ludocolorbackend.employee.domain.model.commands.AddEmployeeCommand;
import com.flabum.ludocolorbackend.employee.interfaces.rest.resources.AddEmployeeCommandResource;

public class AddEmployeeCommandFromResourceAssembler {

    public static AddEmployeeCommand toCommandFromResource(AddEmployeeCommandResource resource) {
        return new AddEmployeeCommand(resource.name(), resource.phone());
    }
}
