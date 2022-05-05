package com.gmail.deamon999.service;

import javax.inject.Inject;
import javax.validation.ConstraintViolationException;

import io.quarkus.test.junit.QuarkusTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class GreetingServiceTest {

    //Unit Tests

    @Inject
    GreetingService greetingService;

    @Test
    public void testGreetingServiceForYoungers() {
        Assertions.assertThatExceptionOfType(ConstraintViolationException.class)
                .isThrownBy(() -> greetingService.greetingMessage(15));
    }

    @Test
    public void testGreetingServiceForTeenagers() {
        String message = greetingService.greetingMessage(18);
        Assertions.assertThat(message).isEqualTo("Hey boys and girls");
    }

    @Test
    public void testGreetingServiceForAdult() {
        String message = greetingService.greetingMessage(21);
        Assertions.assertThat(message).isEqualTo("Hey ladies and gentlemen");
    }
}
