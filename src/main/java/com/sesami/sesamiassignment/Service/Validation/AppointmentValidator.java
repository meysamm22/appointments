package com.sesami.sesamiassignment.Service.Validation;

import com.sesami.sesamiassignment.Model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentValidator {

    @Autowired
    private AppointmentExistanceValidator existanceValidator;

    public void validate(Appointment appointment){
        existanceValidator.validate(appointment);
    }
}
