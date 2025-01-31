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
        var client = clientRepository.findById(command.id());
        if (client.isEmpty()){
            throw new RuntimeException("Client don't exists with this id");
        }
        if (clientRepository.existsByName(command.name())){
            throw new RuntimeException("You cannot update with this name because a client already exists with this name");
        }
        client.get().setName(command.name());
        client.get().setPhone(command.phone());
        client.get().setPoints(command.points());

        return Optional.of(clientRepository.save(client.get()));
    }

    @Override
    public boolean execute(DeleteClientByIdCommand command) {
        if(!clientRepository.existsById(command.id())){
            throw new RuntimeException("Client don't exists with this id");
        }
        clientRepository.deleteById(command.id());
        return true;
    }
}
