package com.flabum.ludocolorbackend.product.interfaces.acl;

import com.flabum.ludocolorbackend.product.domain.model.aggregates.Product;
import com.flabum.ludocolorbackend.product.domain.model.queries.GetProductByIdQuery;
import com.flabum.ludocolorbackend.product.domain.services.ProductCommandService;
import com.flabum.ludocolorbackend.product.domain.services.ProductQueryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class ProductFacadeContext {

    private final ProductCommandService productCommandService;
    private final ProductQueryService productQueryService;

    public Optional<Product> getProductById(Long productId) {
        var getProductByIdCommand = new GetProductByIdQuery(productId);
        return productQueryService.execute(getProductByIdCommand);
    }


}
