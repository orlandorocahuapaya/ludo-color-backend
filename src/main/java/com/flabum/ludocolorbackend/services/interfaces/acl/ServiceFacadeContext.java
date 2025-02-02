package com.flabum.ludocolorbackend.services.interfaces.acl;

import com.flabum.ludocolorbackend.services.domain.model.queries.GetServiceByIdQuery;
import com.flabum.ludocolorbackend.services.domain.services.ServiceCommandService;
import com.flabum.ludocolorbackend.services.domain.services.ServiceQueryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class ServiceFacadeContext {

    private final ServiceCommandService serviceCommandService;
    private final ServiceQueryService serviceQueryService;

    public Optional<com.flabum.ludocolorbackend.services.domain.model.aggregates.Service> getServiceById(Long id) {
        var getServiceById = new GetServiceByIdQuery(id);
        return serviceQueryService.execute(getServiceById);
    }

}
