package com.test.client;

import com.test.dto.booking_details.Booking;
import com.test.dto.booking_details.BookingDetails;
import com.test.dto.booking_details.CreateBookingDetails;
import org.springframework.stereotype.Component;

import static com.test.enums.EndPointEnum.BOOKING;
import static com.test.enums.EndPointEnum.ID;

@Component
public class PutRestClient extends BaseApiConfig {

    public BookingDetails updateBooking(String token, String body, int id) {

        return getGeneralRequest()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
//                .header("Authorisation", "Basic " + token)
                .header("Cookie", "token= " + token)
                .body(body)
                .put(baseUrl + BOOKING.getEndPoint() + String.format(ID.getEndPoint(), id))
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract()
                .body()
                .as(BookingDetails.class);
    }

    public CreateBookingDetails createBooking(String token, String body) {

        return getGeneralRequest()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
//                .header("Authorisation", "Basic " + token)
                .header("Cookie", "token= " + token)
                .body(body)
                .post(baseUrl + BOOKING.getEndPoint())
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract()
                .body()
                .as(CreateBookingDetails.class);
    }
}
