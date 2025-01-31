package com.flabum.ludocolorbackend.clients.domain.services;

import com.flabum.ludocolorbackend.clients.domain.model.aggregates.Client;
import com.flabum.ludocolorbackend.clients.domain.model.queries.GetAllClientsQuery;
import com.flabum.ludocolorbackend.clients.domain.model.queries.GetClientByIdQuery;

import java.util.List;
import java.util.Optional;

public interface ClientQueryService {

    List<Client> getAllClients(GetAllClientsQuery query);

    Optional<Client> getClientById(GetClientByIdQuery query);

}
