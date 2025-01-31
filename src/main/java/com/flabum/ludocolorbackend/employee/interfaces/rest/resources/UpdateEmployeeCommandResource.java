package com.flabum.ludocolorbackend.employee.interfaces.rest.resources;

public record UpdateEmployeeCommandResource(Long id, String name, String phone) {
}
