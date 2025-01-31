package com.flabum.ludocolorbackend.product.domain.services;

import com.flabum.ludocolorbackend.product.domain.model.aggregates.Product;
import com.flabum.ludocolorbackend.product.domain.model.commands.AddProductCommand;
import com.flabum.ludocolorbackend.product.domain.model.commands.DeleteProductByIdCommand;
import com.flabum.ludocolorbackend.product.domain.model.commands.UpdateProductCommand;

import java.util.Optional;

public interface ProductCommandService {

    Optional<Product> execute (AddProductCommand command);

    boolean execute (DeleteProductByIdCommand command);

    Optional<Product> execute (UpdateProductCommand command);

}
