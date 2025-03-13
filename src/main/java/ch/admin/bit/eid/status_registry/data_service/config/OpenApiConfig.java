/*
 * SPDX-FileCopyrightText: 2025 Swiss Confederation
 *
 * SPDX-License-Identifier: MIT
 */

package ch.admin.bit.eid.status_registry.data_service.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class OpenApiConfig {

    private final BuildProperties buildProperties;

    @Bean
    public OpenAPI api() {
        return new OpenAPI().info(new Info()
                        .title("Status Registry Data Service")
                        .description("APIs for the Status Registry Data Services")
                        .version(buildProperties.getVersion())
                )
                .addSecurityItem(new SecurityRequirement()
                        .addList("bearer-jwt")
                        .addList("basicAuth")
                )
                .components(new Components()
                        .addSecuritySchemes("bearer-jwt", new SecurityScheme()
                                .name("bearerAuth")
                                .description("JWT authentication")
                                .bearerFormat("jwt")
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .in(SecurityScheme.In.HEADER)
                        )
                        .addSecuritySchemes("basicAuth", new SecurityScheme()
                                .name("basicAuth")
                                .description("Basic authentication")
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("basic"))
                );
    }
}