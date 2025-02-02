package com.flabum.ludocolorbackend.payment.domain.services;

import com.flabum.ludocolorbackend.payment.domain.model.aggregates.Order;
import com.flabum.ludocolorbackend.payment.domain.model.command.AddOrderCommand;

import java.util.Optional;

public interface OrderCommandService {

    Optional<Order> execute(AddOrderCommand command);

}
