package com.flabum.ludocolorbackend.payment.interfaces.rest.transform;

import com.flabum.ludocolorbackend.employee.domain.model.aggregates.Employee;
import com.flabum.ludocolorbackend.payment.domain.model.aggregates.Order;
import com.flabum.ludocolorbackend.payment.domain.model.command.AddParticipationCommand;
import com.flabum.ludocolorbackend.payment.interfaces.rest.resource.AddParticipationCommandResource;

public class AddParticipationCommandFromResourceAssembler {
    public static AddParticipationCommand toCommandfromResource(AddParticipationCommandResource resource,Employee employee, Order order) {
        return new AddParticipationCommand(employee,order, resource.participationPercentage());
    }
}
