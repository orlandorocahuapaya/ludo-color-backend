package com.flabum.ludocolorbackend.payment.interfaces.rest.transform;

import com.flabum.ludocolorbackend.payment.domain.model.aggregates.Sale;
import com.flabum.ludocolorbackend.payment.domain.model.command.AddOrderCommand;
import com.flabum.ludocolorbackend.payment.interfaces.rest.resource.AddOrderCommandResource;
import com.flabum.ludocolorbackend.product.domain.model.aggregates.Product;
import com.flabum.ludocolorbackend.services.domain.model.aggregates.Service;

public class AddOrderCommandFromResourceAssembler{

    public static AddOrderCommand toCommandFromResource(AddOrderCommandResource resource, Sale sale, Product product, Service service){
        return new AddOrderCommand(sale, product, service, resource.amount(), resource.price());
    }

}
