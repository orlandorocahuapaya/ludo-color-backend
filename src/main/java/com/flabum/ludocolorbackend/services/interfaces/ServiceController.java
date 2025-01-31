package com.flabum.ludocolorbackend.services.interfaces;
import com.flabum.ludocolorbackend.services.domain.model.commands.DeleteServiceByIdCommand;
import com.flabum.ludocolorbackend.services.domain.model.queries.GetAllServicesQuery;
import com.flabum.ludocolorbackend.services.domain.model.queries.GetServiceByIdQuery;
import com.flabum.ludocolorbackend.services.domain.services.ServiceCommandService;
import com.flabum.ludocolorbackend.services.domain.services.ServiceQueryService;
import com.flabum.ludocolorbackend.services.interfaces.rest.resources.AddServiceCommandResource;
import com.flabum.ludocolorbackend.services.interfaces.rest.resources.ServiceResource;
import com.flabum.ludocolorbackend.services.interfaces.rest.resources.UpdateServiceCommandResource;
import com.flabum.ludocolorbackend.services.interfaces.rest.transform.AddServiceCommandFromResourceAssembler;
import com.flabum.ludocolorbackend.services.interfaces.rest.transform.ServiceResourceFromEntityAssembler;
import com.flabum.ludocolorbackend.services.interfaces.rest.transform.UpdateServiceCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "api/v1/service", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name="Service", description = "Service Management Endpoints")
public class ServiceController {

    public final ServiceCommandService serviceCommandService;
    public final ServiceQueryService serviceQueryService;

    @GetMapping()
    public ResponseEntity<List<ServiceResource>> getAllService() {
        var getAllServiceQuery = new GetAllServicesQuery();
        var services = serviceQueryService.execute(getAllServiceQuery);
        var servicesResource = services.stream().map(service -> new ServiceResource(service.getId(), service.getName(), service.getServiceType(), service.getPrice())).toList();
        return ResponseEntity.ok(servicesResource);
    }

    @GetMapping("get-service")
    public ResponseEntity<ServiceResource> getAllService(@RequestParam("id") Long id) {
        var getServiceByIdQuery = new GetServiceByIdQuery(id);
        var Service = serviceQueryService.execute(getServiceByIdQuery);
        var ServiceResource = ServiceResourceFromEntityAssembler.toResourceFromEntity(Service.get());
        return ResponseEntity.ok(ServiceResource);
    }

    @PostMapping("add-service")
    public ResponseEntity<ServiceResource> addService(@RequestBody AddServiceCommandResource resource) {
        var addServiceCommand = AddServiceCommandFromResourceAssembler.toCommandFromResource(resource);
        var Service = serviceCommandService.execute(addServiceCommand);
        var ServiceResource = ServiceResourceFromEntityAssembler.toResourceFromEntity(Service.get());
        return ResponseEntity.ok(ServiceResource);
    }

    @DeleteMapping("delete-service")
    public ResponseEntity<Boolean> deleteService(@RequestParam("id") Long id) {
        var deleteEmployeByIdCommand = new DeleteServiceByIdCommand(id);
        var isServiceDeleted = serviceCommandService.execute(deleteEmployeByIdCommand);
        return ResponseEntity.ok(isServiceDeleted);
    }

    @PutMapping("update-service")
    public ResponseEntity<ServiceResource> updateService(@RequestBody UpdateServiceCommandResource resource) {
        var updateServiceCommand = UpdateServiceCommandFromResourceAssembler.toCommandFromResource(resource);
        var Service = serviceCommandService.execute(updateServiceCommand);
        var ServiceResource = ServiceResourceFromEntityAssembler.toResourceFromEntity(Service.get());
        return ResponseEntity.ok(ServiceResource);
    }

}
