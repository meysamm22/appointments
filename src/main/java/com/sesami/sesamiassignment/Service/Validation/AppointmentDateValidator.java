package com.sesami.sesamiassignment.Service.Validation;

import com.sesami.sesamiassignment.Exception.AppointmentDateException;
import com.sesami.sesamiassignment.Exception.AppointmentExistsException;
import com.sesami.sesamiassignment.Model.Appointment;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service @NoArgsConstructor
public class AppointmentDateValidator extends BaseValidator {

    private static final int MAXIMUM_APPOINTMENT_DURATION_MINUTE = 120;

    protected void validate(Appointment appointment){
        long diff = this.getDateDiff(appointment.getStart(), appointment.getEnd(), TimeUnit.MINUTES);
        if (diff >= MAXIMUM_APPOINTMENT_DURATION_MINUTE || diff < 0)
            throw new AppointmentDateException("The appointment duration is not valid, this is more than " + MAXIMUM_APPOINTMENT_DURATION_MINUTE + " Minutes");
    }

    private long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
        long diffInMillies = date2.getTime() - date1.getTime();
        return timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS);
    }
}
