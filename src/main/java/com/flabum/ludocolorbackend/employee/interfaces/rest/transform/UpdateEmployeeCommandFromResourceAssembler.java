package com.flabum.ludocolorbackend.employee.interfaces.rest.transform;

import com.flabum.ludocolorbackend.employee.domain.model.commands.UpdateEmployeeCommand;
import com.flabum.ludocolorbackend.employee.interfaces.rest.resources.UpdateEmployeeCommandResource;

public class UpdateEmployeeCommandFromResourceAssembler{
    public static UpdateEmployeeCommand toCommandFromResource(UpdateEmployeeCommandResource resource) {
        return new UpdateEmployeeCommand(resource.id(), resource.name(), resource.phone());
    }
}
