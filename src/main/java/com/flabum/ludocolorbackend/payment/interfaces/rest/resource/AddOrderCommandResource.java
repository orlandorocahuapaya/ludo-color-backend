package com.flabum.ludocolorbackend.payment.interfaces.rest.resource;

import com.flabum.ludocolorbackend.payment.domain.model.aggregates.Sale;
import com.flabum.ludocolorbackend.payment.domain.model.command.AddOrderCommand;
import com.flabum.ludocolorbackend.product.domain.model.aggregates.Product;
import com.flabum.ludocolorbackend.product.interfaces.rest.resources.ProductResource;
import com.flabum.ludocolorbackend.services.domain.model.aggregates.Service;
import com.flabum.ludocolorbackend.services.interfaces.rest.resources.ServiceResource;

public record AddOrderCommandResource(Sale sale, Integer amount, Double price) {
}
