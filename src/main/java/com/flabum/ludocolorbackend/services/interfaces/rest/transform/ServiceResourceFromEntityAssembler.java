package com.flabum.ludocolorbackend.services.interfaces.rest.transform;

import com.flabum.ludocolorbackend.services.domain.model.aggregates.Service;
import com.flabum.ludocolorbackend.services.interfaces.rest.resources.ServiceResource;

public class ServiceResourceFromEntityAssembler {

    public static ServiceResource toResourceFromEntity(Service service){
        return new ServiceResource(service.getId(), service.getName(), service.getServiceType(), service.getPrice());
    }

}
