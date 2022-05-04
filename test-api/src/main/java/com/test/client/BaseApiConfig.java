package com.test.client;

import io.restassured.specification.RequestSpecification;
import org.springframework.beans.factory.annotation.Value;

import static io.restassured.RestAssured.given;

public class BaseApiConfig {
    @Value("${api.url.base}")
    protected String baseUrl;

    public RequestSpecification getGeneralRequest() {
        return given()
                .relaxedHTTPSValidation()
                .log()
                .all();
    }
}
