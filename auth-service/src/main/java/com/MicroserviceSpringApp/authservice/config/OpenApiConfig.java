package com.MicroserviceSpringApp.authservice.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Auth service",
                description = "Auth service", version = "1.0.0",
                contact = @Contact(
                        name = "Goldstein Igor",
                        email = "igorgoldshteyn@yandex.ru"
                )
        )
)
public class OpenApiConfig {
}
