package com.flabum.ludocolorbackend.product.interfaces.rest.resources;

public record UpdateProductCommandResource(Long id ,String name, String brand, String productSet, Double price) {
}
