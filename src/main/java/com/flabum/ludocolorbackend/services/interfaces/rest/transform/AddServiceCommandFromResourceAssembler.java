package com.flabum.ludocolorbackend.services.interfaces.rest.transform;

import com.flabum.ludocolorbackend.services.domain.model.commands.AddServiceCommand;
import com.flabum.ludocolorbackend.services.interfaces.rest.resources.AddServiceCommandResource;

public class AddServiceCommandFromResourceAssembler {
    public static AddServiceCommand toCommandFromResource(AddServiceCommandResource resource) {
        return new AddServiceCommand(resource.name(), resource.serviceType(), resource.price());
    }
}
