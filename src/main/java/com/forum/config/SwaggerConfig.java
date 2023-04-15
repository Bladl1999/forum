package com.forum.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("users")
                .pathsToMatch("/users")
                .pathsToMatch("/users/**")
                .build();
    }

    @Bean
    public OpenAPI customOpenApi(
            @Value("${APPLICATION_NAME:USER-SERVICE}") String appName,
            @Value("${APPLICATION_DESCRIPTION:Фо́рум (лат. forum — арх. преддверие гробницы; площадка в давильне для подлежащего обработке винограда; рыночная площадь, городской рынок; торжище, центральная площадь):}") String appDescription,
            @Value("${APPLICATION_VERSION: 0.0.1-SNAPSHOT}") String appVersion) {

        return new OpenAPI().info(new Info().title(appName)
                .version(appVersion)
                .description(appDescription));
    }
}
