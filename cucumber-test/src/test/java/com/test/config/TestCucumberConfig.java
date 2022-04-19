package com.test.config;

import com.test.TestCoreConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan({"com.test"})
@Import({TestCoreConfig.class, TestApiConfig.class})
public class TestCucumberConfig {

}
