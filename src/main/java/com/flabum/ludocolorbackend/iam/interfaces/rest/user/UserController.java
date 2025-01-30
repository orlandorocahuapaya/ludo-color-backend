package com.flabum.ludocolorbackend.iam.interfaces.rest.user;

import com.flabum.ludocolorbackend.iam.domain.services.UserCommandService;
import com.flabum.ludocolorbackend.iam.infrastructure.token.jwts.services.TokenServiceImpl;
import com.flabum.ludocolorbackend.iam.interfaces.rest.user.resources.*;
import com.flabum.ludocolorbackend.iam.interfaces.rest.user.transform.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping(value = "api/v1/users", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name="Users", description = "Users Management Endpoints")
public class UserController {

    private final UserCommandService userCommandService;

    @GetMapping("sign-in")
    public ResponseEntity<AuthenticateUserResource> signIn(@RequestParam String name, HttpServletResponse response, HttpServletRequest request) {
        var signInCommand = SignInCommandFromResourceAssembler.toCommandFromResource(new SignInResource(name));
        var user = userCommandService.execute(signInCommand);
        if (user.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var token = user.get().right;
        var authenticatedUserResource = UserResourceFromEntityAssembler.toResourceFromEntityAndToken(user.get().left, user.get().right);
        TokenServiceImpl.saveJwtInCookie(response, token);
        return ResponseEntity.ok(authenticatedUserResource);
    }

}
