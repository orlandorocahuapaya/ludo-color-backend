package com.flabum.ludocolorbackend.product.domain.model.commands;

public record UpdateProductCommand(Long id,
                                   String name,
                                   String brand,
                                   String productSet,
                                   Double price
                                   ) {
}
