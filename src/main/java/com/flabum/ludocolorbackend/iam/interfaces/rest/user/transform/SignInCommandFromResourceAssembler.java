package com.flabum.ludocolorbackend.iam.interfaces.rest.user.transform;


import com.flabum.ludocolorbackend.iam.domain.model.commands.SignInCommand;
import com.flabum.ludocolorbackend.iam.interfaces.rest.user.resources.SignInResource;

public class SignInCommandFromResourceAssembler {
    public static SignInCommand toCommandFromResource(SignInResource resource){
        return new SignInCommand(resource.name());
    }
}
