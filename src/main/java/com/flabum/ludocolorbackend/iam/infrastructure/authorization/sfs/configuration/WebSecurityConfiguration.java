package com.flabum.ludocolorbackend.iam.infrastructure.authorization.sfs.configuration;


import com.flabum.ludocolorbackend.iam.infrastructure.authorization.sfs.pipeline.BearerAuthorizationRequestFilter;
import com.flabum.ludocolorbackend.iam.infrastructure.authorization.sfs.service.UserDetailsServiceImpl;
import com.flabum.ludocolorbackend.iam.infrastructure.hashing.bcrypt.BCryptHashingService;
import com.flabum.ludocolorbackend.iam.infrastructure.token.jwts.BearerTokenService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableMethodSecurity
public class WebSecurityConfiguration {

    private final BCryptHashingService bCryptHashingService;
    private final UserDetailsServiceImpl userDetailsService;
    private final BearerTokenService bearerTokenService;


    public WebSecurityConfiguration(BCryptHashingService bCryptHashingService
    , UserDetailsServiceImpl userDetailsService, BearerTokenService bearerTokenService) {
        this.userDetailsService = userDetailsService;
        this.bCryptHashingService = bCryptHashingService;
        this.bearerTokenService = bearerTokenService;
    }

    @Bean
    public BearerAuthorizationRequestFilter authorizationRequestFilter() {
        return new BearerAuthorizationRequestFilter(bearerTokenService, userDetailsService);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return bCryptHashingService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable())
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/api/v1/users/sign-in",
                            "/api/v1/users/sign-up",
                            "/api/v1/users/recover-account-email",
                            "/api/v1/users/verify-account",
                            "/swagger-ui/index.html#/Users/signIn",
                            "/swagger-ui/index.html#/Users/signUp",
                            "/swagger-ui/index.html#/Users/recoverAccountEmail",
                            "/swagger-ui/**",
                            "/v3/api-docs/**",
                            "/swagger-resources/**",
                            "/swagger-ui.html",
                            "/webjars/**").permitAll();
                    auth.anyRequest().authenticated();
                })
                .sessionManagement(customizer -> {
                    customizer.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                })
                .addFilterBefore(authorizationRequestFilter(), UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOriginPatterns("http://localhost:5173",
                                "https://ludocolor-backend-production.up.railway.app")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }
}