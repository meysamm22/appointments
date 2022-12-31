package com.sesami.sesamiassignment;

import com.sesami.sesamiassignment.Exception.AppointmentDateException;
import com.sesami.sesamiassignment.Service.Validation.AppointmentDateValidator;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;


@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestPropertySource(
        locations = "classpath:application-integrationtest.properties")
public class AppointmentDateValidatorTest {

    @Autowired
    private AppointmentDateValidator dateValidator;

    @Autowired
    private AppointmentFixtures fixtures;

    @Test
    void validate_moreThan2HoursRangeAppointment_dontAllow(){
        AppointmentDateException exception = Assertions.assertThrows(AppointmentDateException.class, () -> {
            dateValidator.validate(fixtures.getHighRangeAppointment());
        });

        Assertions.assertEquals("The appointment duration is not valid, this is more than 120 Minutes", exception.getMessage());
    }

    @Test
    void validate_startDateIsLessThanEndDateAppointment_dontAllow() {
        AppointmentDateException exception = Assertions.assertThrows(AppointmentDateException.class, () -> {
            dateValidator.validate(fixtures.getInvalidStartAndEndDateAppointment());
        });

        Assertions.assertEquals("The appointment duration is not valid, the start date is less than the end date", exception.getMessage());
    }
}
