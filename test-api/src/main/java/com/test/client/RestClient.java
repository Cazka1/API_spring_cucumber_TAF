package com.test.client;

import com.test.dto.booking_details.BookingDetails;
import org.springframework.stereotype.Component;

import static com.test.enums.EndPointEnum.AUTH;
import static com.test.enums.EndPointEnum.BOOKING;
import static com.test.enums.EndPointEnum.ID;


@Component
public class RestClient extends BaseApiConfig {

    public String getAuthCreateToken() {
        String body = "{ \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"}";
        return getGeneralRequest()
                .header("Content-Type", "application/json")
                .body(body)
                .post(baseUrl + AUTH.getEndPoint())
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath()
                .getString("token");

    }

    public String getBooking() {
        return getGeneralRequest()
                .header("Accept", "application/json")
                .get(baseUrl + BOOKING.getEndPoint())
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract()
                .body()
                .asString();
    }
    public BookingDetails getBookingById(int id) {
        return getGeneralRequest()
                .header("Accept", "application/json")
                .get(baseUrl + BOOKING.getEndPoint() + String.format(ID.getEndPoint(), id))
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract()
                .body()
                .as(BookingDetails.class);
    }
}
