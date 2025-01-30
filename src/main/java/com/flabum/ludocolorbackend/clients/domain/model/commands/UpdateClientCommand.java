package com.flabum.ludocolorbackend.clients.domain.model.commands;

public record UpdateClientCommand(Long id, String name, String phone, Integer points) {
}
