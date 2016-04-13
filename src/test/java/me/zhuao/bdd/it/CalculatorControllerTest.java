package me.zhuao.bdd.it;

import com.jayway.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class CalculatorControllerTest {

    @Before
    public void setUp() {
        RestAssured.baseURI = "http://localhost";
    }

    @Test
    public void should_return_result_string_for_calculate_amount() {
        given()
                .param("expression", "3+4")
                .get("/calculate")
        .then()
                .body(is("7"));
    }

    @Test
    public void should_return_result_string_for_calculate_multiple() {
        given()
                .param("expression", "3*4")
                .get("/calculate")
                .then()
                .body(is("12"));
    }
}
