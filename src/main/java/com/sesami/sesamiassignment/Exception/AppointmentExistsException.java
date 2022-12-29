package com.sesami.sesamiassignment.Exception;

public class AppointmentExistsException extends AppointmentValidationException {

    public AppointmentExistsException(String message, int appointmentId) {
        super(message, appointmentId);
    }
}
