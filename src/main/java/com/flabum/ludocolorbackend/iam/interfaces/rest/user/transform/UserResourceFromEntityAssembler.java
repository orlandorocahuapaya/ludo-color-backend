package com.flabum.ludocolorbackend.iam.interfaces.rest.user.transform;


import com.flabum.ludocolorbackend.iam.domain.model.aggregates.User;
import com.flabum.ludocolorbackend.iam.interfaces.rest.user.resources.AuthenticateUserResource;

public class UserResourceFromEntityAssembler {
    public static AuthenticateUserResource toResourceFromEntityAndToken(User user, String token){
        return new AuthenticateUserResource(user.getId(), user.getName(), token);
    }
}
