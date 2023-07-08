package ru.rightcode.rightcoderestservice.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.OpenAPI;
import lombok.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "RightCode",
                        url = "https://rightcode.ru",
                        email = "rightcode@mail.ru"
                ),
                description = "RightCode REST API",
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.apache.org/licenses/LICENSE-2.0.html"
                ),
                title = "RightCode REST API",
                version = "1.0.0",
                termsOfService = "https://rightcode.ru/terms-of-service"
        ),
        servers = {
                @Server(
                        description = "Localhost",
                        url = "http://localhost:8080"
                ),
                @Server(
                        description = "Heroku",
                        url = "https://rightcoderestservice.herokuapp.com"
                )
        }
)
public class SwaggerConfig {
}
