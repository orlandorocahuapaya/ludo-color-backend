package com.flabum.ludocolorbackend.clients.interfaces.rest.client.resources;

public record UpdateClientResource(Long id, String name, String phone, Integer points) {
}
