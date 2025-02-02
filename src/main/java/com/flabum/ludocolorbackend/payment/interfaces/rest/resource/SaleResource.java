package com.flabum.ludocolorbackend.payment.interfaces.rest.resource;

import com.flabum.ludocolorbackend.clients.interfaces.rest.client.resources.ClientResources;

import java.util.List;

public record SaleResource(ClientResources client, List<OrderResource> orders, String payment_method, String date) {
}
