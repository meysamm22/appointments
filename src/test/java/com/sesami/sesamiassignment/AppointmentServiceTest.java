package com.sesami.sesamiassignment;

import com.sesami.sesamiassignment.Model.Appointment;
import com.sesami.sesamiassignment.Repository.AppointmentRepository;
import com.sesami.sesamiassignment.Service.AppointmentService;
import com.sesami.sesamiassignment.Service.Validation.AppointmentValidator;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.text.ParseException;
import java.util.Optional;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestPropertySource(
        locations = "classpath:application-integrationtest.properties")
public class AppointmentServiceTest {

    @Mock
    private AppointmentValidator validator;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private AppointmentRepository repository;

    @Autowired
    private AppointmentFixtures fixtures;

    @Test
    void process_validAppointment_storeToDB() throws ParseException {
        Appointment fixture = fixtures.getNormalAppointment();
        Mockito.doNothing().when(validator).validate(Mockito.any());
        appointmentService.process(fixture);

        Optional<Appointment> dbAppointment = repository.findFirstByOrderByIdDesc();
        Assertions.assertTrue(dbAppointment.isPresent());
        Assertions.assertEquals(
                fixture.getStart(), dbAppointment.get().getStart()
        );
        Assertions.assertEquals(
                fixture.getEnd(), fixture.getEnd()
        );
    }


    @AfterAll
    void down(){
        repository.deleteAll();
    }
}
