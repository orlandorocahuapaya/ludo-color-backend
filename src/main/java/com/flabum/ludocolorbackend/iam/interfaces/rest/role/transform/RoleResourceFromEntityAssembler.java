package com.flabum.ludocolorbackend.iam.interfaces.rest.role.transform;


import com.flabum.ludocolorbackend.iam.domain.model.entities.Role;
import com.flabum.ludocolorbackend.iam.interfaces.rest.role.resource.RoleResource;

public class RoleResourceFromEntityAssembler {
    public static RoleResource toResourceFromEntity(Role role){
        return new RoleResource(role.getId(), role.getStringName());
    }
}
