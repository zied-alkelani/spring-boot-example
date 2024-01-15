package com.school.configuration;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@Configuration
@ComponentScan
@OpenAPIDefinition
public class OpenApiConfiguration {
    private OpenAPI apiInfo() {
        final Contact contact = new Contact().name("School SAAS")
                .email("mail@school.com")
                .url("www.school.com");
        final License license = new License().url("API license URL");

        return new OpenAPI()
                .info(new Info()
                        .title("Smart Learn Core API")
                        .description("Core API of the Smart Learn System")
                        .contact(contact)
                        .version("v0.0.1")
                        .termsOfService("Terms Of Service")
                        .license(license));
    }

    @Bean
    public GroupedOpenApi api() {
        return GroupedOpenApi.builder()
                .group("Smart LearnCore API")
                .pathsToMatch("/**")
                .build();
    }
}
