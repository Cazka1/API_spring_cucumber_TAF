
package com.test.dto.booking_details;

import io.cucumber.messages.internal.com.fasterxml.jackson.annotation.JsonInclude;
import io.cucumber.messages.internal.com.fasterxml.jackson.annotation.JsonProperty;
import io.cucumber.messages.internal.com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import javax.annotation.Generated;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "firstname",
    "lastname",
    "totalprice",
    "depositpaid",
    "bookingdates",
    "additionalneeds"
})
@Generated("jsonschema2pojo")
public class BookingDetails {

    @JsonProperty("firstname")
    private String firstname;
    @JsonProperty("lastname")
    private String lastname;
    @JsonProperty("totalprice")
    private Integer totalprice;
    @JsonProperty("depositpaid")
    private Boolean depositpaid;
    @JsonProperty("bookingdates")
    private Bookingdates bookingdates;
    @JsonProperty("additionalneeds")
    private String additionalneeds;

}
