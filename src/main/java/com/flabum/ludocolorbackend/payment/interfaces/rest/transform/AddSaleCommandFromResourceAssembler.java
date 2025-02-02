package com.flabum.ludocolorbackend.payment.interfaces.rest.transform;

import com.flabum.ludocolorbackend.clients.domain.model.aggregates.Client;
import com.flabum.ludocolorbackend.clients.interfaces.acl.ClientFacadeContext;
import com.flabum.ludocolorbackend.payment.domain.model.aggregates.Order;
import com.flabum.ludocolorbackend.payment.domain.model.aggregates.Sale;
import com.flabum.ludocolorbackend.payment.domain.model.command.AddSaleCommand;
import com.flabum.ludocolorbackend.payment.domain.model.valueobject.PaymentMethod;
import com.flabum.ludocolorbackend.payment.interfaces.rest.resource.AddSaleCommandResource;
import com.flabum.ludocolorbackend.payment.interfaces.rest.resource.OrderResource;
import com.flabum.ludocolorbackend.product.domain.model.aggregates.Product;
import lombok.AllArgsConstructor;
import org.aspectj.weaver.ast.Or;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@AllArgsConstructor
public class AddSaleCommandFromResourceAssembler {



    public static AddSaleCommand toCommandFromResource(AddSaleCommandResource resource, Client client) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return new AddSaleCommand(client,
                PaymentMethod.valueOf(resource.payment_method()), formatter.parse(resource.date()) );
    }

}
