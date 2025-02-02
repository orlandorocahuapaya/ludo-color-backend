package com.flabum.ludocolorbackend.payment.interfaces.rest.resource;

import com.flabum.ludocolorbackend.employee.interfaces.rest.resources.EmployeeResource;

public record ParticipationResource(EmployeeResource employee, Double participationPercentage) {
}
