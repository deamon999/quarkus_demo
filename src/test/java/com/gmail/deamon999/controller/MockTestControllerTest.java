package com.gmail.deamon999.controller;

import static org.hamcrest.CoreMatchers.is;

import com.gmail.deamon999.service.GreetingService;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@QuarkusTest
public class MockTestControllerTest {

    //Integration Tests
    @InjectMock
    GreetingService greetingService;

    @BeforeEach
    public void prepareMocks() {
        Mockito.when(greetingService.greetingMessage(16))
                .thenReturn("Aloha from Mockito");
    }

    @Test
    public void testMockEndpoint() {
        RestAssured.given()
                .param("age", 16)
                .when().get("/test/greeting")
                .then()
                .statusCode(200)
                .body(is("Aloha from Mockito"));
    }
}
