package com.flabum.ludocolorbackend.iam.domain.services;

import com.flabum.ludocolorbackend.iam.domain.model.commands.SeedRolesCommand;

public interface RoleCommandService {

    void execute(SeedRolesCommand command);

}
