package com.sesami.sesamiassignment.Exception;

import lombok.Data;

@Data
public class AppointmentValidationException extends RuntimeException{
    public AppointmentValidationException(String message) {
        super(message);
    }
}