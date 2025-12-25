package com.example.demo.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        final String securitySchemeName = "bearerAuth";
        
        return new OpenAPI()
                .info(apiInfo())
                .addSecurityItem(new SecurityRequirement()
                        .addList(securitySchemeName))
                .components(new Components()
                        .addSecuritySchemes(securitySchemeName,
                                new SecurityScheme()
                                        .name(securitySchemeName)
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")
                                        .description("Enter JWT token in format: Bearer <token>")));
    }

    private Info apiInfo() {
        return new Info()
                .title("Farm Management System API")
                .description("""
                        ### REST API for Farm Management System
                        
                        This API provides endpoints for:
                        - User authentication and registration
                        - Farm management (CRUD operations)
                        - Crop catalog management
                        - Fertilizer catalog management
                        - Smart suggestions for crops based on farm conditions
                        
                        ### Authentication
                        Most endpoints require JWT authentication. 
                        First, register a user or login to get a token, 
                        then include it in the Authorization header as: 
                        `Authorization: Bearer <your-token>`
                        
                        ### Roles
                        - **USER**: Can manage farms and get suggestions
                        - **ADMIN**: Can also manage crop and fertilizer catalogs
                        """)
                .version("1.0.0")
                .contact(new Contact()
                        .name("Support Team")
                        .email("support@example.com")
                        .url("https://example.com"))
                .license(new License()
                        .name("Apache 2.0")
                        .url("https://www.apache.org/licenses/LICENSE-2.0.html"))
                .termsOfService("https://example.com/terms");
    }
}