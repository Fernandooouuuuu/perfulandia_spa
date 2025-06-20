package com.perfulandia.perfulandiaspa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new io.swagger.v3.oas.models.info.Info()
                        .title("Perfulandia Spa API")
                        .version("1.0")
                        .description("API documentacion para Perfulandia Spa"));
    }

}
