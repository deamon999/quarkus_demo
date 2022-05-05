package com.gmail.deamon999.controller;

import static org.hamcrest.CoreMatchers.is;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class TestControllerTest {

    //Behavioral Tests

    @Test
    public void testGET_TestEndpoint() {
        RestAssured.given()
                .header("authorization", "Bearer XYZ")
                .param("order", "asc")
                .when().get("/test")
                .then()
                .statusCode(200)
                .body(is("URI: http://localhost:8083/test - Order asc - Authorization: Bearer XYZ"));
    }


    @Test
    public void testPOST_TestEndpoint() {
        RestAssured.with().body("test")
                .when().post("/test")
                .then()
                .statusCode(200)
                .body(is("test"));
    }

}