package com.flabum.ludocolorbackend.product.interfaces.rest.resources;

public record AddProductCommandResource(String name, String brand, String productSet, Double price) {
}
