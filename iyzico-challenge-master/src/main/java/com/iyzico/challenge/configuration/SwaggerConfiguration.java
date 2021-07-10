package com.iyzico.challenge.configuration;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static springfox.documentation.builders.PathSelectors.regex;

public class SwaggerConfiguration implements WebMvcConfigurer{
	
	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("iyzico-api")
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(regex("/api.*"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Iyzico API",
                "Iyzico Coding Challenge",
                "1.0.0",
                null,
                new Contact("Can Özer", "https://github.com/ccanozerr", "ccanozerr@gmail.com"),
                null, null, Collections.emptyList());
    }

}
