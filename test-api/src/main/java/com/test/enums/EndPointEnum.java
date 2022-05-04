package com.test.enums;

import lombok.Getter;

public enum EndPointEnum {
    AUTH("/auth"),
    BOOKING("/booking"),
    ID("/%s");
    @Getter
    private final String endPoint;

    EndPointEnum(String endPoint) {
        this.endPoint = endPoint;
    }
}
