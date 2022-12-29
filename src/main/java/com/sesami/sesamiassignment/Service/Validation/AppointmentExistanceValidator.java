package com.sesami.sesamiassignment.Service.Validation;

import com.sesami.sesamiassignment.Exception.AppointmentExistsException;
import com.sesami.sesamiassignment.Model.Appointment;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service @NoArgsConstructor
public class AppointmentExistanceValidator extends BaseValidator {

    protected void validate(Appointment appointment){
        repository.findByStartAndEnd(appointment.getStart(), appointment.getEnd())
                .ifPresent( appointment1 -> {throw new AppointmentExistsException("Requested Appointment is exists", appointment.getId());
                });
    }
}
