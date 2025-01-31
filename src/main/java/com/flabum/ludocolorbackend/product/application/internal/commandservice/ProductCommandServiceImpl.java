package com.flabum.ludocolorbackend.product.application.internal.commandservice;

import com.flabum.ludocolorbackend.employee.domain.model.aggregates.Employee;
import com.flabum.ludocolorbackend.product.domain.model.aggregates.Product;
import com.flabum.ludocolorbackend.product.domain.model.commands.AddProductCommand;
import com.flabum.ludocolorbackend.product.domain.model.commands.DeleteProductByIdCommand;
import com.flabum.ludocolorbackend.product.domain.model.commands.UpdateProductCommand;
import com.flabum.ludocolorbackend.product.domain.services.ProductCommandService;
import com.flabum.ludocolorbackend.product.infrastructure.persistence.jpa.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class ProductCommandServiceImpl implements ProductCommandService {

    private final ProductRepository productRepository;

    @Override
    public Optional<Product> execute(AddProductCommand command) {
        var newProduct = new Product(command.name(), command.brand(), command.productSet(), command.price());
        return Optional.of(productRepository.save(newProduct));
    }

    @Override
    public boolean execute(DeleteProductByIdCommand command) {
        if (!productRepository.existsById(command.id())){
            throw new RuntimeException("Product id does not exist");
        }
        productRepository.deleteById(command.id());
        return true;
    }

    @Override
    public Optional<Product> execute(UpdateProductCommand command) {
        var product = productRepository.findById(command.id());
        product.get().setName(command.name());
        product.get().setBrand(command.brand());
        product.get().setProductSet(command.productSet());
        product.get().setPrice(command.price());
        return Optional.of(productRepository.save(product.get()));
    }
}
