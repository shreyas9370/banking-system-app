package com.banking.configuration;

import org.springframework.context.annotation.Bean;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"!prod && swagger"})
@OpenAPIDefinition
public class SwaggerConfiguration {
    Contact contact = new Contact().name("Shreyas Raut").email("shreyas.raut@hoonartek.com").url("");

    @Bean
    public OpenAPI baseOpenApi(){
        return new OpenAPI().info(new Info().title("Bank Management System")
                .description("Bank operations")
                .contact(contact)
        );
    }
}
