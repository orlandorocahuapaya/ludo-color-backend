package com.flabum.ludocolorbackend.product.interfaces.rest.transform;

import com.flabum.ludocolorbackend.product.domain.model.commands.AddProductCommand;
import com.flabum.ludocolorbackend.product.interfaces.rest.resources.AddProductCommandResource;

public class AddProductCommandFromResourceAssembler {

    public static AddProductCommand toCommandFromResource(AddProductCommandResource resource) {
        return new AddProductCommand(resource.name(), resource.brand(), resource.productSet(), resource.price());
    }

}
