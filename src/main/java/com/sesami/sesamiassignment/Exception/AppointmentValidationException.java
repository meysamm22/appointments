package com.sesami.sesamiassignment.Exception;

public class AppointmentValidationException extends RuntimeException{
    public AppointmentValidationException(String message) {
        super(message);
    }
}