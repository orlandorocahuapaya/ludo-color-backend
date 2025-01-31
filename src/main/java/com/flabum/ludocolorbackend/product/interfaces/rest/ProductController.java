package com.flabum.ludocolorbackend.product.interfaces.rest;



import com.flabum.ludocolorbackend.product.domain.model.commands.DeleteProductByIdCommand;
import com.flabum.ludocolorbackend.product.domain.model.queries.GetAllProductQuery;
import com.flabum.ludocolorbackend.product.domain.model.queries.GetProductByIdQuery;
import com.flabum.ludocolorbackend.product.domain.services.ProductCommandService;
import com.flabum.ludocolorbackend.product.domain.services.ProductQueryService;
import com.flabum.ludocolorbackend.product.interfaces.rest.resources.AddProductCommandResource;
import com.flabum.ludocolorbackend.product.interfaces.rest.resources.ProductResource;
import com.flabum.ludocolorbackend.product.interfaces.rest.resources.UpdateProductCommandResource;
import com.flabum.ludocolorbackend.product.interfaces.rest.transform.AddProductCommandFromResourceAssembler;
import com.flabum.ludocolorbackend.product.interfaces.rest.transform.ProductResourceFromEntityAssembler;
import com.flabum.ludocolorbackend.product.interfaces.rest.transform.UpdateProductCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "api/v1/product", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name="Product", description = "Product Management Endpoints")
public class ProductController {

    public final ProductQueryService productQueryService;
    public final ProductCommandService productCommandService;

    @GetMapping()
    public ResponseEntity<List<ProductResource>> getAllProduct() {
        var getAllProductQuery = new GetAllProductQuery();
        var products = productQueryService.execute(getAllProductQuery);
        var productsResource = products.stream().map(product -> new ProductResource(product.getId(), product.getName(), product.getBrand(), product.getProductSet(), product.getPrice())).toList();
        return ResponseEntity.ok(productsResource);
    }

    @GetMapping("get-product")
    public ResponseEntity<ProductResource> getAllProduct(@RequestParam("id") Long id) {
        var getProductByIdQuery = new GetProductByIdQuery(id);
        var product = productQueryService.execute(getProductByIdQuery);
        var productResource = ProductResourceFromEntityAssembler.toResourceFromEntity(product.get());
        return ResponseEntity.ok(productResource);
    }

    @PostMapping("add-product")
    public ResponseEntity<ProductResource> addProduct(@RequestBody AddProductCommandResource resource) {
        var addProductCommand = AddProductCommandFromResourceAssembler.toCommandFromResource(resource);
        var product = productCommandService.execute(addProductCommand);
        var productResource = ProductResourceFromEntityAssembler.toResourceFromEntity(product.get());
        return ResponseEntity.ok(productResource);
    }

    @DeleteMapping("delete-product")
    public ResponseEntity<Boolean> deleteProduct(@RequestParam("id") Long id) {
        var deleteEmployeByIdCommand = new DeleteProductByIdCommand(id);
        var isProductDeleted = productCommandService.execute(deleteEmployeByIdCommand);
        return ResponseEntity.ok(isProductDeleted);
    }

    @PutMapping("update-product")
    public ResponseEntity<ProductResource> updateProduct(@RequestBody UpdateProductCommandResource resource) {
        var updateProductCommand = UpdateProductCommandFromResourceAssembler.toCommandFromResource(resource);
        var product = productCommandService.execute(updateProductCommand);
        var productResource = ProductResourceFromEntityAssembler.toResourceFromEntity(product.get());
        return ResponseEntity.ok(productResource);
    }
    
}
