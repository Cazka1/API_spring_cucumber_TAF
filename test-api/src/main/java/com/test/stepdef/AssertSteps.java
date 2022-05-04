package com.test.stepdef;

import com.test.client.RestClient;
import com.test.dto.booking_details.BookingDetails;
import com.test.scenario_context.ScenarioContext;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static com.test.scenario_context.enums.ScenarioContextEnum.ACTUAL_UPDATE;
import static com.test.scenario_context.enums.ScenarioContextEnum.EXPECTED_UPDATE;
import static com.test.scenario_context.enums.ScenarioContextEnum.ID;
import static org.assertj.core.api.Assertions.assertThat;

public class AssertSteps {

    @Autowired
    private ScenarioContext scenarioContext;

    @Autowired
    private RestClient restClient;

    @Then("Assert book")
    public void assertBook() {
        BookingDetails actual = scenarioContext.getContext(ACTUAL_UPDATE);
        BookingDetails expected = scenarioContext.getContext(EXPECTED_UPDATE);
        assertThat(expected.equals(actual)).as("Expected: %s, Actual: %s", expected, actual).isFalse();
    }

    @Then("User checks that deatails is deleted")
    public void userChecksThatDeatailsIsDeleted() {
        String idList = restClient.getBooking();
        int id = scenarioContext.getContext(ID);
        assertThat(idList.contains(String.valueOf(id))).as("Expected: %s, Actual: %s", id, idList).isFalse();
    }
}