package com.flabum.ludocolorbackend.services.domain.model.commands;

public record AddServiceCommand(String name,
                                String serviceType,
                                Double price
                                ) {
}
