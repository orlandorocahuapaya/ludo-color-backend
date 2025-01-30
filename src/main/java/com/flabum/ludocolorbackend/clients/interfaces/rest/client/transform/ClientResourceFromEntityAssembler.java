package com.flabum.ludocolorbackend.clients.interfaces.rest.client.transform;

import com.flabum.ludocolorbackend.clients.domain.model.aggregates.Client;
import com.flabum.ludocolorbackend.clients.interfaces.rest.client.resources.ClientResources;

public class ClientResourceFromEntityAssembler {
    public static ClientResources toResourceFromEntity(Client client) {
        return new ClientResources(client.getId(), client.getName(), client.getPhone(), client.getPoints());
    }
}
