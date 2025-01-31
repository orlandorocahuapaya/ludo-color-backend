package com.flabum.ludocolorbackend.services.application.internal.queryservice;

import com.flabum.ludocolorbackend.clients.domain.model.queries.GetAllClientsQuery;
import com.flabum.ludocolorbackend.services.domain.model.queries.GetAllServicesQuery;
import com.flabum.ludocolorbackend.services.domain.model.queries.GetServiceByIdQuery;
import com.flabum.ludocolorbackend.services.domain.services.ServiceQueryService;
import com.flabum.ludocolorbackend.services.infrastructure.persistence.jpa.ServiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ServiceQueryServiceImpl implements ServiceQueryService {

    private final ServiceRepository serviceRepository;

    @Override
    public List<com.flabum.ludocolorbackend.services.domain.model.aggregates.Service> execute(GetAllServicesQuery query) {
        return serviceRepository.findAll();
    }

    @Override
    public Optional<com.flabum.ludocolorbackend.services.domain.model.aggregates.Service> execute(GetServiceByIdQuery query) {
        return serviceRepository.findById(query.id());
    }
}
