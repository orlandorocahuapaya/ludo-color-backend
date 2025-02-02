package com.flabum.ludocolorbackend.payment.domain.model.command;

import com.flabum.ludocolorbackend.employee.domain.model.aggregates.Employee;
import com.flabum.ludocolorbackend.payment.domain.model.aggregates.Order;

import java.util.List;

public record AddParticipationCommand(Employee employee, Order order, Double participationPercentage) {
}
