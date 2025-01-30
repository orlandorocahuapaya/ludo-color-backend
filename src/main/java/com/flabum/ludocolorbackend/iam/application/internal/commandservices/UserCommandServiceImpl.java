package com.flabum.ludocolorbackend.iam.application.internal.commandservices;

import com.flabum.ludocolorbackend.iam.domain.model.aggregates.User;
import com.flabum.ludocolorbackend.iam.domain.model.commands.*;
import com.flabum.ludocolorbackend.iam.domain.services.UserCommandService;
import com.flabum.ludocolorbackend.iam.infrastructure.hashing.bcrypt.BCryptHashingService;
import com.flabum.ludocolorbackend.iam.infrastructure.persistence.jpa.repositories.RoleRepository;
import com.flabum.ludocolorbackend.iam.infrastructure.persistence.jpa.repositories.UserRepository;
import com.flabum.ludocolorbackend.iam.infrastructure.token.jwts.TokenService;
import com.flabum.ludocolorbackend.iam.infrastructure.token.jwts.services.TokenServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UserCommandServiceImpl implements UserCommandService {
    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final BCryptHashingService bcryptHashingService;

    private final TokenService tokenService;

    private final TokenServiceImpl tokenServiceImpl;

    @Override
    public Optional<ImmutablePair<User, String>> execute(SignInCommand command) {
        var user = userRepository.findByName(command.name());
        if (user.isEmpty()){
            throw new RuntimeException("User not found");
        }
        var userName= user.get().getName();
        var token = tokenService.generateToken(userName);
        return Optional.of(ImmutablePair.of(user.get(), token));
    }
}
