package com.flabum.ludocolorbackend.clients.interfaces.rest.client.transform;

import com.flabum.ludocolorbackend.clients.domain.model.commands.UpdateClientCommand;
import com.flabum.ludocolorbackend.clients.interfaces.rest.client.resources.UpdateClientResource;

public class UpdateClientCommandFromResourceAssembler {
    public static UpdateClientCommand toCommandFromResource(UpdateClientResource resource){
        return new UpdateClientCommand(resource.id() ,resource.name(), resource.phone(), resource.points());
    }

}
