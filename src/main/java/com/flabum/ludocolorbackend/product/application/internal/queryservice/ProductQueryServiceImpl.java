package com.flabum.ludocolorbackend.product.application.internal.queryservice;

import com.flabum.ludocolorbackend.product.domain.model.aggregates.Product;
import com.flabum.ludocolorbackend.product.domain.model.queries.GetAllProductQuery;
import com.flabum.ludocolorbackend.product.domain.model.queries.GetProductByIdQuery;
import com.flabum.ludocolorbackend.product.domain.services.ProductQueryService;
import com.flabum.ludocolorbackend.product.infrastructure.persistence.jpa.ProductRepository;
import com.flabum.ludocolorbackend.services.infrastructure.persistence.jpa.ServiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProductQueryServiceImpl implements ProductQueryService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> execute(GetAllProductQuery query) {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> execute(GetProductByIdQuery query) {
        return productRepository.findById(query.id());
    }
}
