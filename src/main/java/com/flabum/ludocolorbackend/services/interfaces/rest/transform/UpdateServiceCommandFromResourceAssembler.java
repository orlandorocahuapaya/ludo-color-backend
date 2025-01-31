package com.flabum.ludocolorbackend.services.interfaces.rest.transform;

import com.flabum.ludocolorbackend.product.interfaces.rest.resources.UpdateProductCommandResource;
import com.flabum.ludocolorbackend.services.domain.model.commands.UpdateServiceCommand;
import com.flabum.ludocolorbackend.services.interfaces.rest.resources.UpdateServiceCommandResource;

public class UpdateServiceCommandFromResourceAssembler {
    public static UpdateServiceCommand toCommandFromResource(UpdateServiceCommandResource resource) {
        return new UpdateServiceCommand(resource.id(), resource.name(), resource.serviceType(), resource.price());
    }
}
