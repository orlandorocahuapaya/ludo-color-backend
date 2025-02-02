package com.flabum.ludocolorbackend.payment.application.internal.commandservices;

import com.flabum.ludocolorbackend.employee.domain.model.aggregates.Employee;
import com.flabum.ludocolorbackend.employee.interfaces.acl.EmployeeFacadeContext;
import com.flabum.ludocolorbackend.payment.domain.model.command.AddParticipationCommand;
import com.flabum.ludocolorbackend.payment.domain.model.entities.Participation;
import com.flabum.ludocolorbackend.payment.domain.services.ParticipationCommandService;
import com.flabum.ludocolorbackend.payment.infrastructure.persistence.jpa.ParticipationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class ParticipationCommandServiceImpl implements ParticipationCommandService {

    private final EmployeeFacadeContext employeeFacadeContext;
    private final ParticipationRepository participationRepository;

    @Override
    public Optional<Participation> execute(AddParticipationCommand command) {
        var participation = new Participation(command.employee(), command.order(), command.participationPercentage());
        return Optional.of(participationRepository.save(participation));
    }
}
