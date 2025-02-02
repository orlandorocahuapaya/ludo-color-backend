package com.flabum.ludocolorbackend.payment.interfaces.rest.resource;

import java.util.List;

public record OrderResource(Integer typeOfItem,
                            String name,
                            Integer amount,
                            Double uniquePrice,
                            Long productId,
                            Long serviceId,
                            List<ParticipationResource> participation
) {

    public OrderResource(Integer typeOfItem, String name, Integer amount, Double uniquePrice) {
        this(typeOfItem, name, amount, uniquePrice, null, null, null);
    }
}
