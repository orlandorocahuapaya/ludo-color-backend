package com.flabum.ludocolorbackend.payment.domain.services;

import com.flabum.ludocolorbackend.payment.domain.model.command.AddParticipationCommand;
import com.flabum.ludocolorbackend.payment.domain.model.entities.Participation;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ParticipationCommandService {

    Optional<Participation> execute(AddParticipationCommand command);

}
