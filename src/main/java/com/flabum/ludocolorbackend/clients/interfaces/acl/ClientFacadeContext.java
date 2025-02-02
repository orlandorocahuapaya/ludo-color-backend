package com.flabum.ludocolorbackend.clients.interfaces.acl;

import com.flabum.ludocolorbackend.clients.domain.model.aggregates.Client;
import com.flabum.ludocolorbackend.clients.domain.model.queries.GetClientByIdQuery;
import com.flabum.ludocolorbackend.clients.domain.services.ClientQueryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class ClientFacadeContext {

    private ClientQueryService clientQueryService;

    public Optional<Client> getClientById(Long id) {
        var getCLientByIdQuery = new GetClientByIdQuery(id);
        return clientQueryService.getClientById(getCLientByIdQuery);
    }



}
