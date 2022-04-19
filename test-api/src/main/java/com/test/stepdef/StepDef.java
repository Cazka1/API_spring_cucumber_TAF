package com.test.stepdef;

import io.cucumber.java.en.Given;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StepDef {
    @Given("Test world")
    public void testWorld() {
    log.info("message: {}", "test");
    }
}
