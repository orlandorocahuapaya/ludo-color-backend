package com.flabum.ludocolorbackend.payment.domain.model.command;

import com.flabum.ludocolorbackend.payment.domain.model.aggregates.Sale;
import com.flabum.ludocolorbackend.payment.domain.model.entities.Participation;
import com.flabum.ludocolorbackend.product.domain.model.aggregates.Product;
import com.flabum.ludocolorbackend.services.domain.model.aggregates.Service;

import java.util.List;

public record AddOrderCommand(Sale sale, Product product, Service service, Integer amount, Double price) {

    public AddOrderCommand (Sale sale, Integer amount, Double price){
        this(sale, null, null, amount, price);
    }
}
