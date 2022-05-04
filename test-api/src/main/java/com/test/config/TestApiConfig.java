package com.test.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.test"})
public class TestApiConfig {
    @Bean
    public ObjectMapper getObjectMapper(){
        return new ObjectMapper();

    }
}
