package com.MicroserviceSpringApp.clientInterface.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Client Interface",
                description = "Client interface service", version = "1.0.0",
                contact = @Contact(
                        name = "Goldstein Igor",
                        email = "igorgoldshteyn@yandex.ru"
                )
        )
)
public class OpenApiConfig {
}
