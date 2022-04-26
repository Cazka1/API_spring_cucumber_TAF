package com.test.stepdef;

import com.test.client.RestClient;
import com.test.data.table.type.FruitType;
import com.test.data.table.type.TripleTextType;
import com.test.dto.booking_details.BookingDetails;
import com.test.service.AuthorisationService;
import com.test.service.FakeService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

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

    @Given("Test world")
    public void testWorld() {
//        log.info("message: {}", url1);
//        log.info("message: {}", userName);
//        fakeService.printValue();
        log.info(authorisationService.concatCreds());
    }

    @Autowired
    private RestClient restClient;

    @Given("get authorisation token")
    public void getAuthorisationToken() {
        String token = restClient.getAuthCreateToken();
        log.info("token = {}", token);
    }

    @And("get booking")
    public void getBooking() {
        BookingDetails booking = restClient.getBooking();
        log.info(String.valueOf(booking));

    }

    @And("get some text")
    public void getSomeText(List<TripleTextType> entity) {
//        log.info(entity.);
//        for (TripleTextType entity1 : entity) {
//            entity1.getText2();
//        }
        entity.forEach(tripleTextType -> {
            log.info(tripleTextType.getText1());
        });
    }

    @And("get some fruit")
    public void getSomeFruit(FruitType entity) {
//        entity.forEach(fruitType -> {
//            log.info(fruitType.getFruit1() + " " + fruitType.getIsFruit());
//        });
    log.debug(entity.getFruit1()+entity.getIsFruit());
    }
}
