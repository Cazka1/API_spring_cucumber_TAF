package com.test.client;

import org.springframework.stereotype.Component;

import static com.test.enums.EndPointEnum.BOOKING;
import static com.test.enums.EndPointEnum.ID;

@Component
public class DeleteRestClient extends BaseApiConfig {

    public void deleteBooking(String token, int id) {
        getGeneralRequest()
//                .header("Authorisation", "Basic " + token)
                .header("Cookie", "token= " + token)
                .delete(baseUrl + BOOKING.getEndPoint() + String.format(ID.getEndPoint(), id))
                .then()
                .log()
                .all()
                .statusCode(201);
    }

}
