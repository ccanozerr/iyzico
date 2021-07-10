package com.iyzico.challenge.config;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.iyzico.challenge.configuration.SwaggerConfiguration;

import springfox.documentation.spring.web.plugins.Docket;

public class SwaggerConfigurationTest {

    @Test
    public void it_should_create_docket(){
        SwaggerConfiguration swaggerConfig = new SwaggerConfiguration();

        Docket docket = swaggerConfig.api();

        assertThat(docket).isInstanceOf(Docket.class);
    }

}
