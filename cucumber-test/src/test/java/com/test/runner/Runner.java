package com.test.runner;

import com.test.config.TestCucumberConfig;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Cucumber.class)
@CucumberOptions(
        stepNotifications = true,
        tags = "@Debug",
        plugin = {"pretty", "html:target/cucumber"},
        features = "classpath:feature",
        extraGlue = {"com.test.stepdef"})
@CucumberContextConfiguration
@SpringBootTest(classes = TestCucumberConfig.class)
public class Runner {
}
