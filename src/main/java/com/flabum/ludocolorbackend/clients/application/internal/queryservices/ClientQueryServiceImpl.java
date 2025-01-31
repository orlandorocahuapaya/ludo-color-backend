package com.flabum.ludocolorbackend.clients.application.internal.queryservices;

import com.flabum.ludocolorbackend.clients.domain.model.aggregates.Client;
import com.flabum.ludocolorbackend.clients.domain.model.queries.GetAllClientsQuery;
import com.flabum.ludocolorbackend.clients.domain.model.queries.GetClientByIdQuery;
import com.flabum.ludocolorbackend.clients.domain.services.ClientQueryService;
import com.flabum.ludocolorbackend.clients.infrastructure.persistence.jpa.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ClientQueryServiceImpl implements ClientQueryService {

    private final ClientRepository clientRepository;

    @Override
    public List<Client> getAllClients(GetAllClientsQuery query) {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> getClientById(GetClientByIdQuery query) {
        return Optional.empty();
    }
}
