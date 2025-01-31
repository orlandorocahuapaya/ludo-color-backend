package com.flabum.ludocolorbackend.product.interfaces.rest.transform;

import com.flabum.ludocolorbackend.product.domain.model.aggregates.Product;
import com.flabum.ludocolorbackend.product.interfaces.rest.resources.ProductResource;

public class ProductResourceFromEntityAssembler {

    public static ProductResource toResourceFromEntity(Product product) {
        return new ProductResource(product.getId(), product.getName(), product.getBrand(), product.getProductSet(), product.getPrice());
    }

}
