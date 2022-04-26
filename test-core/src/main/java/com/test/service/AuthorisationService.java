package com.test.service;

import lombok.AllArgsConstructor;
import lombok.Data;
//bin створений вручну
@Data
@AllArgsConstructor
public class AuthorisationService {

    public static final String CONCAT = "%s%s";
    private String userName;
    private String userPassword;

    public String concatCreds() {
        return String.format(CONCAT, userName, userPassword);
    }
}
