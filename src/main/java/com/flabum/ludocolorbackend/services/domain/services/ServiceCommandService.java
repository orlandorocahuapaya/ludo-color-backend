package com.flabum.ludocolorbackend.services.domain.services;

import com.flabum.ludocolorbackend.services.domain.model.aggregates.Service;
import com.flabum.ludocolorbackend.services.domain.model.commands.AddServiceCommand;
import com.flabum.ludocolorbackend.services.domain.model.commands.DeleteServiceByIdCommand;
import com.flabum.ludocolorbackend.services.domain.model.commands.UpdateServiceCommand;

import java.util.Optional;

public interface ServiceCommandService {

    Optional<Service> execute(AddServiceCommand command);

    boolean execute(DeleteServiceByIdCommand command);

    Optional<Service> execute(UpdateServiceCommand command);

}
