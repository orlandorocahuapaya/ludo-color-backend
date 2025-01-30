package com.flabum.ludocolorbackend.iam.application.internal.queryservices;

import com.flabum.ludocolorbackend.iam.domain.model.entities.Role;
import com.flabum.ludocolorbackend.iam.domain.model.queries.GetAllRolesQuery;
import com.flabum.ludocolorbackend.iam.domain.services.RoleQueryService;
import com.flabum.ludocolorbackend.iam.infrastructure.persistence.jpa.repositories.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class RoleQueryServiceImpl implements RoleQueryService {

    private RoleRepository roleRepository;


    @Override
    public List<Role> execute(GetAllRolesQuery query) {
        return roleRepository.findAll();
    }
}
