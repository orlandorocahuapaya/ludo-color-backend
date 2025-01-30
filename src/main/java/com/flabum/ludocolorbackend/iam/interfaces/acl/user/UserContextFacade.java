package com.flabum.ludocolorbackend.iam.interfaces.acl.user;

import com.flabum.ludocolorbackend.iam.domain.model.aggregates.User;
import com.flabum.ludocolorbackend.iam.domain.services.UserCommandService;
import com.flabum.ludocolorbackend.iam.infrastructure.persistence.jpa.repositories.UserRepository;
import com.flabum.ludocolorbackend.iam.infrastructure.token.jwts.services.TokenServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserContextFacade {
    private final UserCommandService userCommandService;

    private final UserRepository userRepository;

    private final TokenServiceImpl tokenService;


}
