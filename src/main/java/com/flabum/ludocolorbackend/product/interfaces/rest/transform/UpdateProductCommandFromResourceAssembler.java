package com.flabum.ludocolorbackend.product.interfaces.rest.transform;

import com.flabum.ludocolorbackend.product.domain.model.commands.UpdateProductCommand;
import com.flabum.ludocolorbackend.product.interfaces.rest.resources.UpdateProductCommandResource;

public class UpdateProductCommandFromResourceAssembler {

    public static UpdateProductCommand toCommandFromResource(UpdateProductCommandResource resource) {
        return new UpdateProductCommand(resource.id(), resource.name(), resource.brand(), resource.productSet(), resource.price());
    }

}
