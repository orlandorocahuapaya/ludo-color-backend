package com.flabum.ludocolorbackend.product.domain.services;

import com.flabum.ludocolorbackend.product.domain.model.aggregates.Product;
import com.flabum.ludocolorbackend.product.domain.model.queries.GetAllProductQuery;
import com.flabum.ludocolorbackend.product.domain.model.queries.GetProductByIdQuery;

import java.util.List;
import java.util.Optional;

public interface ProductQueryService {

    List<Product> execute(GetAllProductQuery query);

    Optional<Product> execute (GetProductByIdQuery query);

}
