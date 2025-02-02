package com.flabum.ludocolorbackend.payment.interfaces.rest.resource;

import com.flabum.ludocolorbackend.clients.interfaces.rest.client.resources.ClientResources;

import java.util.List;

public record ProcessSaleResource(String payment_method, String date, ClientResources client, List<OrderResource> orders) {
}
