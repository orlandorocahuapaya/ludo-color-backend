package com.flabum.ludocolorbackend.payment.domain.model.command;

import com.flabum.ludocolorbackend.clients.domain.model.aggregates.Client;
import com.flabum.ludocolorbackend.payment.domain.model.aggregates.Order;
import com.flabum.ludocolorbackend.payment.domain.model.valueobject.PaymentMethod;

import java.util.Date;
import java.util.List;

public record AddSaleCommand(Client client, PaymentMethod paymentMethod, Date date) {
}
