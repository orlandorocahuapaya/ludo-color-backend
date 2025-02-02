package com.flabum.ludocolorbackend.payment.application.internal.queryservices;

import com.flabum.ludocolorbackend.payment.domain.model.aggregates.Sale;
import com.flabum.ludocolorbackend.payment.domain.model.queries.GetAllSalesQuery;
import com.flabum.ludocolorbackend.payment.domain.model.queries.GetSaleByIdQuery;
import com.flabum.ludocolorbackend.payment.domain.services.SaleQueryService;
import com.flabum.ludocolorbackend.payment.infrastructure.persistence.jpa.SaleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class SaleQueryServiceImpl implements SaleQueryService {

    private final SaleRepository saleRepository;

    @Override
    public List<Sale> execute(GetAllSalesQuery query) {
        return saleRepository.findAll();
    }

    @Override
    public Optional<Sale> execute(GetSaleByIdQuery query) {
        return saleRepository.findById(query.id());
    }
}
