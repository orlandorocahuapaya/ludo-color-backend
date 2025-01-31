package com.flabum.ludocolorbackend.services.domain.services;

import com.flabum.ludocolorbackend.clients.domain.model.queries.GetAllClientsQuery;
import com.flabum.ludocolorbackend.services.domain.model.aggregates.Service;
import com.flabum.ludocolorbackend.services.domain.model.queries.GetAllServicesQuery;
import com.flabum.ludocolorbackend.services.domain.model.queries.GetServiceByIdQuery;

import java.util.List;
import java.util.Optional;

public interface ServiceQueryService {

    List<Service> execute(GetAllServicesQuery query);

    Optional<Service> execute(GetServiceByIdQuery query);

}
