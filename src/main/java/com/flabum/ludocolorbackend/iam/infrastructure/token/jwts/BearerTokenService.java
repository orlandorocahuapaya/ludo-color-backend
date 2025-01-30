package com.flabum.ludocolorbackend.iam.infrastructure.token.jwts;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;

public interface BearerTokenService extends TokenService {

    String generateToken(Authentication authentication);

    String getBearerTokenFrom(HttpServletRequest token);
}
