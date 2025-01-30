package com.flabum.ludocolorbackend.iam.domain.services;

import com.flabum.ludocolorbackend.iam.domain.model.entities.Role;
import com.flabum.ludocolorbackend.iam.domain.model.queries.GetAllRolesQuery;

import java.util.List;

public interface RoleQueryService {

    List<Role> execute (GetAllRolesQuery query);


}
