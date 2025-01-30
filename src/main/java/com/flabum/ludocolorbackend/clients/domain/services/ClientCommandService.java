package com.flabum.ludocolorbackend.clients.domain.services;

import com.flabum.ludocolorbackend.clients.domain.model.aggregates.Client;
import com.flabum.ludocolorbackend.clients.domain.model.commands.AddClientCommnad;
import com.flabum.ludocolorbackend.clients.domain.model.commands.DeleteClientByIdCommand;
import com.flabum.ludocolorbackend.clients.domain.model.commands.UpdateClientCommand;

import java.util.Optional;

public interface ClientCommandService {

    Optional<Client> execute(AddClientCommnad commnad);

    Optional<Client> execute(UpdateClientCommand command);

    boolean execute (DeleteClientByIdCommand command);

}
