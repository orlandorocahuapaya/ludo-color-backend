package com.flabum.ludocolorbackend.iam.application.internal.commandservices;


import com.flabum.ludocolorbackend.iam.domain.model.commands.SeedRolesCommand;
import com.flabum.ludocolorbackend.iam.domain.model.entities.Role;
import com.flabum.ludocolorbackend.iam.domain.model.valueobjects.Roles;
import com.flabum.ludocolorbackend.iam.domain.services.RoleCommandService;
import com.flabum.ludocolorbackend.iam.infrastructure.persistence.jpa.repositories.RoleRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;


@Service
public class RoleCommandServiceImpl implements RoleCommandService {


    private final RoleRepository roleRepository;

    public RoleCommandServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void execute(SeedRolesCommand command) {
        Arrays.stream(Roles.values()).forEach(role -> {
            if(!roleRepository.existsByName(role)){
                roleRepository.save(new Role(Roles.valueOf(role.name())));
            }
        });
    }
}
