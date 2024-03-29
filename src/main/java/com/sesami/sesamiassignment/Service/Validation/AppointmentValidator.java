package com.sesami.sesamiassignment.Service.Validation;

import com.sesami.sesamiassignment.Model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentValidator {

    @Autowired
    private AppointmentExistanceValidator existanceValidator;
    @Autowired
    private AppointmentDateValidator dateValidator;
    @Autowired
    private AppointmentConflictValidator conflictValidator;

    public void validate(Appointment appointment){
        existanceValidator.validate(appointment);
        dateValidator.validate(appointment);
        conflictValidator.validate(appointment);
    }
}
