package com.test.stepdef;

import com.test.service.AuthorisationService;
import com.test.service.FakeService;
import io.cucumber.java.en.Given;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Slf4j
public class StepDef {

    public static final String URL_1 = "";

    @Value("${api.url1}")
    private String url1;

    @Value("${credential.dev.user.name}")
    private String userName;

    @Autowired
    private FakeService fakeService;

    @Autowired
    private AuthorisationService authorisationService;

    @Given("Test world")
    public void testWorld() {
//        log.info("message: {}", url1);
//        log.info("message: {}", userName);
//        fakeService.printValue();
        log.info(authorisationService.concatCreds());
    }
}
