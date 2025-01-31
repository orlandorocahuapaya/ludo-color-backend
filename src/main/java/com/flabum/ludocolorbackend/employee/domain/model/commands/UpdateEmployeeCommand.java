package com.flabum.ludocolorbackend.employee.domain.model.commands;

public record UpdateEmployeeCommand(Long id, String name, String phone) {
}
