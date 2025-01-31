package com.flabum.ludocolorbackend.product.domain.model.commands;

public record AddProductCommand(String name,
                                String brand,
                                String productSet,
                                Double price
                                ) {
}
