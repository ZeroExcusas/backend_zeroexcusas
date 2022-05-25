package com.zeroexcusas.zeroexcusas_app.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiSettings {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().info(new Info()
                .title("ZeroExcusas")
                .description("Api para ZeroExcusas")
                .version("v1.0")
                .contact(new Contact().name("ZeroExcusasTeam")
                        .url("https://zeroexcusas.com")
                        .email("info@zeroexcusas.com"))
                        .termsOfService("TOC")
                        .license(new License().name("my license").url("https://zeroexcusas.com/license"))
                );
    }
}
