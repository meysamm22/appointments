package com.sesami.sesamiassignment;

import com.sesami.sesamiassignment.Model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
public class AppointmentFixtures {
    @Autowired
    private DateHelper dateHelper;

    public Appointment getNormalAppointment() throws ParseException {
        return Appointment.builder()
                .start(dateHelper.strToDate("2020-10-10 20:20"))
                .end(dateHelper.strToDate("2020-10-10 20:30"))
                .createdAt(dateHelper.strToDate("2020-09-02 14:23:12"))
                .UpdatedAt(dateHelper.strToDate("2020-09-02 14:23:12"))
                .build();
    }

    public Appointment getAnotherNormalAppointment() throws ParseException {
        return Appointment.builder()
                .start(dateHelper.strToDate("2020-10-11 20:20"))
                .end(dateHelper.strToDate("2020-10-11 20:30"))
                .createdAt(dateHelper.strToDate("2020-09-02 14:23:12"))
                .UpdatedAt(dateHelper.strToDate("2020-09-02 14:23:12"))
                .build();
    }
}
