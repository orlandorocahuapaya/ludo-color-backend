package com.flabum.ludocolorbackend.payment.interfaces.rest.transform;

import com.flabum.ludocolorbackend.payment.domain.model.aggregates.Order;
import com.flabum.ludocolorbackend.payment.interfaces.rest.resource.OrderResource;
import com.flabum.ludocolorbackend.payment.interfaces.rest.resource.ParticipationResource;

import java.util.List;

public class OrderResourceFromEntityAssembler {

    public static OrderResource toResourceFromEntity(Order order) {
        Long productId = (order.getProduct() != null) ? order.getProduct().getId() : null;
        Long serviceId = (order.getService() != null) ? order.getService().getId() : null;
        List<ParticipationResource> participationResources = (order.getParticipation() != null)
                ? order.getParticipation().stream()
                .map(ParticipationResourceFromEntityAssembler::toResourceFromEntity)
                .toList()
                : null;
        return new OrderResource(0, order.getName(), order.getAmount(), order.getPrice(), productId, serviceId,
                participationResources);
    }

}
