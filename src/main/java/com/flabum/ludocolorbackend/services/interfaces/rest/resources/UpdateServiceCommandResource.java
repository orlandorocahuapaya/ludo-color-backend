package com.flabum.ludocolorbackend.services.interfaces.rest.resources;

public record UpdateServiceCommandResource(Long id, String name, String serviceType, Double price) {
}
