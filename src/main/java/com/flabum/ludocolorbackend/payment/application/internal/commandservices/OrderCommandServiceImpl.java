package com.flabum.ludocolorbackend.payment.application.internal.commandservices;

import com.flabum.ludocolorbackend.payment.domain.model.aggregates.Order;
import com.flabum.ludocolorbackend.payment.domain.model.command.AddOrderCommand;
import com.flabum.ludocolorbackend.payment.domain.services.OrderCommandService;
import com.flabum.ludocolorbackend.payment.infrastructure.persistence.jpa.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class OrderCommandServiceImpl implements OrderCommandService {

    private final OrderRepository orderRepository;


    @Override
    public Optional<Order> execute(AddOrderCommand command) {
        var order = new Order(command.sale(), command.product(), command.service(), command.amount(), command.price());
        return Optional.of(orderRepository.save(order));
    }
}

