
package com.test.dto.booking_details;

import io.cucumber.messages.internal.com.fasterxml.jackson.annotation.JsonInclude;
import io.cucumber.messages.internal.com.fasterxml.jackson.annotation.JsonProperty;
import io.cucumber.messages.internal.com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import javax.annotation.Generated;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "checkin",
        "checkout"
})
@Generated("jsonschema2pojo")
public class Bookingdates {

    @JsonProperty("checkin")
    private String checkin;
    @JsonProperty("checkout")
    private String checkout;

}
