package com.flabum.ludocolorbackend.clients.application.internal.commandservices;

import com.flabum.ludocolorbackend.clients.domain.model.aggregates.Client;
import com.flabum.ludocolorbackend.clients.domain.model.commands.AddClientCommnad;
import com.flabum.ludocolorbackend.clients.domain.model.commands.DeleteClientByIdCommand;
import com.flabum.ludocolorbackend.clients.domain.model.commands.UpdateClientCommand;
import com.flabum.ludocolorbackend.clients.domain.services.ClientCommandService;
import com.flabum.ludocolorbackend.clients.infrastructure.persistence.jpa.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class ClientCommandServiceImpl implements ClientCommandService {

    private final ClientRepository clientRepository;


    @Override
    public Optional<Client> execute(AddClientCommnad commnad) {
        if (clientRepository.existsByName(commnad.name())){
            throw new RuntimeException("Client already exists with this name");
        }
        var newClient = new Client(commnad.name(), commnad.phone(), commnad.points());
        clientRepository.save(newClient);
        return Optional.of(newClient);
    }

    @Override
    public Optional<Client> execute(UpdateClientCommand command) {
        return Optional.empty();
    }

    @Override
    public boolean execute(DeleteClientByIdCommand command) {
        return false;
    }
}
