package com.test.client;

import com.test.dto.booking_details.BookingDetails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RestClient extends BaseApiConfig {

    public static final String ID = "%s";
    @Value("${api.url.token}")
    private String tokenUrl;
    @Value("${api.url.booking}")
    private String bookingUrl;

    public String getAuthCreateToken() {
        String body = "{ \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"}";
        return getGeneralRequest()
                .header("Content-Type", "application/json")
                .body(body)
                .post(tokenUrl)
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath()
                .getString("token");

    }

    public BookingDetails getBooking() {
        return getGeneralRequest()
                .header("Accept", "application/json")
                .get(bookingUrl + String.format(ID,8))
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract()
                .body()
                .as(BookingDetails.class);
    }
}
