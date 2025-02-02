package com.flabum.ludocolorbackend.payment.domain.services;

import com.flabum.ludocolorbackend.payment.domain.model.aggregates.Sale;
import com.flabum.ludocolorbackend.payment.domain.model.queries.GetAllSalesQuery;
import com.flabum.ludocolorbackend.payment.domain.model.queries.GetSaleByIdQuery;

import java.util.List;
import java.util.Optional;

public interface SaleQueryService {

    List<Sale> execute(GetAllSalesQuery query);

    Optional<Sale> execute (GetSaleByIdQuery query);
}
