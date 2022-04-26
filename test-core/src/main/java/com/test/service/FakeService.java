package com.test.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
//cервіс
@Slf4j
@Component
public class FakeService {
    @Value("${credential.test.user.name}")
    private String userTestName;

    public void printValue(){
        log.info(userTestName);
    }
}
