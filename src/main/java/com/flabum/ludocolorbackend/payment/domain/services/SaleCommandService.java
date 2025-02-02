package com.flabum.ludocolorbackend.payment.domain.services;

import com.flabum.ludocolorbackend.payment.domain.model.aggregates.Sale;
import com.flabum.ludocolorbackend.payment.domain.model.command.AddSaleCommand;
import com.flabum.ludocolorbackend.payment.domain.model.command.DeleteSaleByIdCommand;
import com.flabum.ludocolorbackend.payment.domain.model.command.UpdateSaleCommand;

import java.util.Optional;

public interface SaleCommandService {

    Optional<Sale> execute(AddSaleCommand command);

    boolean execute (DeleteSaleByIdCommand command);

    Optional<Sale> execute (UpdateSaleCommand command);

}
