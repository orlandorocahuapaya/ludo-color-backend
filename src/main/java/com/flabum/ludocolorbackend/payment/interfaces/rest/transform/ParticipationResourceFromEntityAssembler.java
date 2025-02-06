package com.flabum.ludocolorbackend.payment.interfaces.rest.transform;

import com.flabum.ludocolorbackend.employee.interfaces.rest.transform.EmployeeResourceFromEntityAssembler;
import com.flabum.ludocolorbackend.payment.domain.model.entities.Participation;
import com.flabum.ludocolorbackend.payment.interfaces.rest.resource.ParticipationResource;

public class ParticipationResourceFromEntityAssembler {
    public static ParticipationResource toResourceFromEntity(Participation participation) {
        return new ParticipationResource(EmployeeResourceFromEntityAssembler.toResourceFromEntity(participation.getEmployee()),
                participation.getParticipationPercentage());
    }
}