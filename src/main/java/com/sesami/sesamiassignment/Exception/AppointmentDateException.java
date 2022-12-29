package com.sesami.sesamiassignment.Exception;

public class AppointmentDateException extends AppointmentValidationException {

    public AppointmentDateException(String message, int appointmentId) {
        super(message, appointmentId);
    }
}
