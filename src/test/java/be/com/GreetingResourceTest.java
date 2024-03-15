package be.com;

import be.com.reactive.dto.AirbnbDTO;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;


@QuarkusTest
@Disabled
class GreetingResourceTest {
    @Test
    void test_CastArray_Success() {
        AirbnbDTO[] arr = given()
                .when().get("/public/airbnb/list")
                .as(AirbnbDTO[].class);

    }

    @Test
    void test_call_AirbnbList_Success() {
        given()
                .when().get("public/airbnb/list")
                .then().statusCode(HttpStatus.OK.value());
    }

}