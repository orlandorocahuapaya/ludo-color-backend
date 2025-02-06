package com.flabum.ludocolorbackend.services.application.internal.commandservice;

import com.flabum.ludocolorbackend.employee.domain.model.aggregates.Employee;
import com.flabum.ludocolorbackend.payment.infrastructure.persistence.jpa.OrderRepository;
import com.flabum.ludocolorbackend.services.domain.model.commands.AddServiceCommand;
import com.flabum.ludocolorbackend.services.domain.model.commands.DeleteServiceByIdCommand;
import com.flabum.ludocolorbackend.services.domain.model.commands.UpdateServiceCommand;
import com.flabum.ludocolorbackend.services.domain.services.ServiceCommandService;
import com.flabum.ludocolorbackend.services.infrastructure.persistence.jpa.ServiceRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class ServiceCommandServiceImpl implements ServiceCommandService {

    private final ServiceRepository serviceRepository;
    private final OrderRepository orderRepository;

    @Override
    public Optional<com.flabum.ludocolorbackend.services.domain.model.aggregates.Service> execute(AddServiceCommand command) {
        var newService = new com.flabum.ludocolorbackend.services.domain.model.aggregates.Service(command.name(), command.serviceType(), command.price());
        return Optional.of(serviceRepository.save(newService));
    }

    @Override
    @Transactional
    public boolean execute(DeleteServiceByIdCommand command) {
        if (!serviceRepository.existsById(command.id())){
            throw new RuntimeException("Service id does not exist");
        }
        orderRepository.setServiceIdNull(command.id());
        serviceRepository.deleteById(command.id());
        return true;
    }

    @Override
    public Optional<com.flabum.ludocolorbackend.services.domain.model.aggregates.Service> execute(UpdateServiceCommand command) {
        var service = serviceRepository.findById(command.id());
        service.get().setName(command.name());
        service.get().setServiceType(command.serviceType());
        service.get().setPrice(command.price());
        return Optional.of(serviceRepository.save(service.get()));
    }
}
