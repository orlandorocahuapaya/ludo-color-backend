package com.flabum.ludocolorbackend.clients.interfaces.rest.client.transform;

import com.flabum.ludocolorbackend.clients.domain.model.commands.AddClientCommnad;
import com.flabum.ludocolorbackend.clients.interfaces.rest.client.resources.AddClientResource;
import jakarta.annotation.Resource;

public class AddClientCommandFromResourceAssembler {
    public static AddClientCommnad toCommandFromResource(AddClientResource resource) {
        return new AddClientCommnad(resource.name(), resource.phone(), resource.point());
    }
}
