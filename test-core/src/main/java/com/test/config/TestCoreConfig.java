package com.test.config;

import com.test.service.AuthorisationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan({"com.test"})
public class TestCoreConfig {

    @Bean
    public AuthorisationService getAuthorisationService(@Value("${credential.test.user.name}") String userName,
                                                        @Value("${credential.test.user.password}") String userPassword) {
        return new AuthorisationService(userName, userPassword);
    }
}
