package com.flabum.ludocolorbackend.payment.interfaces.rest.transform;

import com.flabum.ludocolorbackend.clients.domain.model.aggregates.Client;
import com.flabum.ludocolorbackend.clients.interfaces.rest.client.resources.ClientResources;
import com.flabum.ludocolorbackend.employee.interfaces.rest.resources.EmployeeResource;
import com.flabum.ludocolorbackend.payment.domain.model.aggregates.Sale;
import com.flabum.ludocolorbackend.payment.domain.model.valueobject.PaymentMethod;
import com.flabum.ludocolorbackend.payment.interfaces.rest.resource.OrderResource;
import com.flabum.ludocolorbackend.payment.interfaces.rest.resource.ParticipationResource;
import com.flabum.ludocolorbackend.payment.interfaces.rest.resource.SaleResource;

import java.text.SimpleDateFormat;

public class SaleResourceFromEntityAssembler {

    public static SaleResource toResourceFromEntity(Sale sale) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        ClientResources clientResource = (sale.getClient() != null) ?
                new ClientResources(
                        sale.getClient().getId(),
                        sale.getClient().getName(),
                        sale.getClient().getPhone(),
                        sale.getClient().getPoints()
                ) :
                new ClientResources(null, "CLIENTE X", null, null);
        return new SaleResource(
                clientResource,
                sale.getOrders().stream().map(order -> OrderResourceFromEntityAssembler.toResourceFromEntity(order)).toList(),
                sale.getPaymentMethod().toString(),
                formatter.format(sale.getDate()));
    }

}
