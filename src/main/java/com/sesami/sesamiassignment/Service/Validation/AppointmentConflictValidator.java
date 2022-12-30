package com.sesami.sesamiassignment.Service.Validation;

import com.sesami.sesamiassignment.Exception.AppointmentConflictException;
import com.sesami.sesamiassignment.Model.Appointment;
import org.springframework.stereotype.Service;


@Service
public class AppointmentConflictValidator extends BaseValidator{
    protected void validate(Appointment appointment){
       repository.findConflicts(appointment.getStart(), appointment.getEnd())
               .ifPresent( dbAppointment -> {
                   if (appointment.getId() == null || !dbAppointment.getId().equals(appointment.getId()))
                       throw new AppointmentConflictException("Requested Appointment has conflict with other appointments");
               });

    }
}
