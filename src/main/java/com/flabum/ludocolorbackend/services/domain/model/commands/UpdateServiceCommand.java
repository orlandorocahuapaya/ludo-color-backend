package com.flabum.ludocolorbackend.services.domain.model.commands;

public record UpdateServiceCommand(Long id,
                                   String name,
                                   String serviceType,
                                   Double price
                                   ) {
}
