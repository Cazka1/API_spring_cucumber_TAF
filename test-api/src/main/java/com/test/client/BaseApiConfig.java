package com.test.client;

import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BaseApiConfig {
    public RequestSpecification getGeneralRequest(){
        return given()
                .relaxedHTTPSValidation()
                .log()
                .all();
    }
}
