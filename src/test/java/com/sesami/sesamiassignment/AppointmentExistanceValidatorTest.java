package com.sesami.sesamiassignment;

import com.sesami.sesamiassignment.Exception.AppointmentExistsException;
import com.sesami.sesamiassignment.Repository.AppointmentRepository;
import com.sesami.sesamiassignment.Service.Validation.AppointmentExistanceValidator;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.text.ParseException;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestPropertySource(
        locations = "classpath:application-integrationtest.properties")
public class AppointmentExistanceValidatorTest {

    @Autowired
    private AppointmentExistanceValidator existanceValidator;

    @Autowired
    private AppointmentRepository repository;

    @Autowired
    private AppointmentFixtures fixtures;


    @BeforeAll
    void setUp() throws ParseException {
        repository.save(fixtures.getNormalAppointment());
    }

    @Test
    void validate_douplicatedAppointment_dontAllow(){
        Assertions.assertThrows(AppointmentExistsException.class, () -> {
            existanceValidator.validate(fixtures.getNormalAppointment());
        });
    }

    @Test
    void validate_newAppointment_allow() throws ParseException {
        existanceValidator.validate(fixtures.getAnotherNormalAppointment());

    }

    @AfterAll
    void down(){
        repository.deleteAll();
    }
}
