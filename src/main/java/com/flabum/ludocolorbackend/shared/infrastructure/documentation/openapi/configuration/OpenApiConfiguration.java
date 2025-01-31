package com.flabum.ludocolorbackend.shared.infrastructure.documentation.openapi.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI learningPlatformOpenApi() {

        return new OpenAPI()
                .info(new Info().title("Ludo Color Platform API")
                        .description(
                                "Ludo Color Platform application REST API documentation.")
                        .version("v1.0.0")
                                .license(new License().name("company: Flabum SAC developer: Orlando Arturo Roca Huapaya").url("https://springdoc.org")));

    }

}
