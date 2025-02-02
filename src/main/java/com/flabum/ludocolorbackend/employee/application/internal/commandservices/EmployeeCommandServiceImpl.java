package com.flabum.ludocolorbackend.employee.application.internal.commandservices;

import com.flabum.ludocolorbackend.employee.domain.model.aggregates.Employee;
import com.flabum.ludocolorbackend.employee.domain.model.commands.AddEmployeeCommand;
import com.flabum.ludocolorbackend.employee.domain.model.commands.DeleteEmployeeByIdCommand;
import com.flabum.ludocolorbackend.employee.domain.model.commands.UpdateEmployeeCommand;
import com.flabum.ludocolorbackend.employee.domain.service.EmployeeCommandService;
import com.flabum.ludocolorbackend.employee.infrastructure.persistence.jpa.EmployeeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class EmployeeCommandServiceImpl implements EmployeeCommandService {

    private final EmployeeRepository employeeRepository;
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Employee getEmployeeManaged(Long id) {
        Employee employee = entityManager.find(Employee.class, id);
        if (employee == null) {
            throw new EntityNotFoundException("❌ Empleado no encontrado con ID: " + id);
        }
        return employee; // Asegura que está en la sesión
    }


    @Override
    public Optional<Employee> execute(AddEmployeeCommand command) {
        if (employeeRepository.existsByName(command.name())){
            throw new RuntimeException("Employee name already exists");
        }
        var newEmployee = new Employee(command.phone(), command.name());
        return Optional.of(employeeRepository.save(newEmployee));
    }

    @Override
    public boolean execute(DeleteEmployeeByIdCommand commnad) {
        if (!employeeRepository.existsById(commnad.id())){
            throw new RuntimeException("Employee id does not exist");
        }
        employeeRepository.deleteById(commnad.id());
        return true;
    }

    @Override
    public Optional<Employee> execute(UpdateEmployeeCommand commnad) {
        var employee = employeeRepository.findById(commnad.id());
        if (employeeRepository.countByName(commnad.name()) >= 2){
            throw new RuntimeException("Employee name already exists");
        }
        employee.get().setName(commnad.name());
        employee.get().setPhone(commnad.phone());
        return Optional.of(employeeRepository.save(employee.get()));
    }
}
