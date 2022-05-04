package com.test.stepdef;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.client.DeleteRestClient;
import com.test.client.PutRestClient;
import com.test.client.RestClient;
import com.test.data.table.type.FruitType;
import com.test.data.table.type.TripleTextType;
import com.test.dto.booking_details.Booking;
import com.test.dto.booking_details.BookingDetails;
import com.test.dto.booking_details.Bookingdates;
import com.test.dto.booking_details.CreateBookingDetails;
import com.test.scenario_context.ScenarioContext;
import com.test.service.AuthorisationService;
import com.test.service.FakeService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

import static com.test.scenario_context.enums.ScenarioContextEnum.ACTUAL_UPDATE;
import static com.test.scenario_context.enums.ScenarioContextEnum.EXPECTED_UPDATE;
import static com.test.scenario_context.enums.ScenarioContextEnum.ID;

@Slf4j
public class StepDef {

    public static final String URL_1 = "";

    @Value("${api.url1}")
    private String url1;

    @Value("${credential.dev.user.name}")
    private String userName;

    @Autowired
    private FakeService fakeService;

    @Autowired
    private AuthorisationService authorisationService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private DeleteRestClient deleteRestClient;

    @Autowired
    private RestClient restClient;

    @Autowired
    private PutRestClient putRestClient;

    @Autowired
    private ScenarioContext scenarioContext;

    @Given("Test world")
    public void testWorld() {
//        log.info("message: {}", url1);
//        log.info("message: {}", userName);
//        fakeService.printValue();
        log.info(authorisationService.concatCreds());
    }

    @Given("get authorisation token")
    public void getAuthorisationToken() {
        String token = restClient.getAuthCreateToken();
        log.info("token = {}", token);
    }

    @And("get booking")
    public void getBooking() {
        String booking = restClient.getBooking();
        log.info(String.valueOf(booking));

    }

    @And("get some text")
    public void getSomeText(List<TripleTextType> entity) {
//        log.info(entity.);
//        for (TripleTextType entity1 : entity) {
//            entity1.getText2();
//        }
        System.out.format("Thread ID - %2d \n", Thread.currentThread().getId());
        entity.forEach(tripleTextType -> {
            log.info(tripleTextType.getText1());
        });
    }

    @And("get some fruit")
    public void getSomeFruit(FruitType entity) {
//        entity.forEach(fruitType -> {
//            log.info(fruitType.getFruit1() + " " + fruitType.getIsFruit());
//        });
        log.debug(entity.getFruit1() + entity.getIsFruit());
    }

    @Given("get {int}")
    public void get(int value) {
        System.out.format("Thread ID - %2d \n", Thread.currentThread().getId());
        log.info(String.valueOf(value));
    }

    @SneakyThrows
    @Given("create booking details")
    public void createBookingDetails() {
        Booking booking = new Booking();
        Bookingdates bookingdates = new Bookingdates();
        CreateBookingDetails createBookingDetails = new CreateBookingDetails();
        bookingdates.setCheckin("2022-01-05");
        bookingdates.setCheckout("2024-01-05");
        booking.setBookingdates(bookingdates);
        booking.setFirstname("Name");
        booking.setLastname("LastName");
        booking.setDepositpaid(true);
        booking.setTotalprice(122);
        booking.setAdditionalneeds("Breakfast");
        createBookingDetails.setBookingid(10);
        createBookingDetails.setBooking(booking);

        CreateBookingDetails createBooking = putRestClient
                .createBooking(restClient.getAuthCreateToken(), objectMapper.writeValueAsString(booking));
        scenarioContext.setScenarioContext(ACTUAL_UPDATE, createBooking);
        scenarioContext.setScenarioContext(ID, createBooking.getBookingid());
    }

    @SneakyThrows
    @And("update booking details")
    public void updateBookingDetails() {
        int id = scenarioContext.getContext(ID);
        BookingDetails updatedBookingDetails = new BookingDetails();
        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("new 2022-01-01");
        bookingdates.setCheckout("new 2024-01-01");
        updatedBookingDetails.setBookingdates(bookingdates);
        updatedBookingDetails.setFirstname("new Name");
        updatedBookingDetails.setLastname("new LastName");
        updatedBookingDetails.setDepositpaid(false);
        updatedBookingDetails.setTotalprice(666);
        updatedBookingDetails.setAdditionalneeds("new Breakfast");

        BookingDetails old = restClient.getBookingById(id);
        BookingDetails updateBooking = putRestClient
                .updateBooking(restClient.getAuthCreateToken(), objectMapper.writeValueAsString(updatedBookingDetails), id);
        Thread.sleep(200);
        BookingDetails newDetails = restClient.getBookingById(id);
        scenarioContext.setScenarioContext(ACTUAL_UPDATE, newDetails);
        scenarioContext.setScenarioContext(EXPECTED_UPDATE, old);
    }

    @And("Delete book")
    public void deleteBook() {
        int id = scenarioContext.getContext(ID);
        deleteRestClient.deleteBooking(restClient.getAuthCreateToken(), id);
    }
}