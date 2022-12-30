package com.sesami.sesamiassignment.Exception;

public class AppointmentExistsException extends AppointmentValidationException {

    public AppointmentExistsException(String message) {
        super(message);
    }
}
