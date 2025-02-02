package com.flabum.ludocolorbackend.payment.application.internal.commandservices;

import com.flabum.ludocolorbackend.clients.interfaces.acl.ClientFacadeContext;
import com.flabum.ludocolorbackend.payment.domain.model.aggregates.Sale;
import com.flabum.ludocolorbackend.payment.domain.model.command.AddSaleCommand;
import com.flabum.ludocolorbackend.payment.domain.model.command.DeleteSaleByIdCommand;
import com.flabum.ludocolorbackend.payment.domain.model.command.UpdateSaleCommand;
import com.flabum.ludocolorbackend.payment.domain.services.OrderCommandService;
import com.flabum.ludocolorbackend.payment.domain.services.SaleCommandService;
import com.flabum.ludocolorbackend.payment.infrastructure.persistence.jpa.SaleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class SaleCommandServiceImpl implements SaleCommandService {

    private final SaleRepository saleRepository;
    private final OrderCommandService orderCommandService;
    private final ClientFacadeContext clientFacadeContext;

    @Override
    public Optional<Sale> execute(AddSaleCommand command) {
        var newSale = new Sale(command.client(), command.paymentMethod(), command.date());
        return Optional.of(saleRepository.save(newSale));
    }


    @Override
    public boolean execute(DeleteSaleByIdCommand command) {
        saleRepository.deleteById(command.id());
        return true;
    }

    @Override
    public Optional<Sale> execute(UpdateSaleCommand command) {
        var sale = saleRepository.findById(command.id()).orElseThrow(()-> new RuntimeException("Sale not found"));

        sale.setClient(command.client());
        sale.setPaymentMethod(command.paymentMethod());
        sale.setOrders(command.orders());
        sale.setDate(command.date());

        return Optional.of(saleRepository.save(sale));
    }
}