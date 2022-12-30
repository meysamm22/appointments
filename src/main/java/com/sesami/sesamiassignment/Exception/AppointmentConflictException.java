package com.sesami.sesamiassignment.Exception;

public class AppointmentConflictException extends AppointmentValidationException {

    public AppointmentConflictException(String message) {
        super(message, 0);
    }
}
