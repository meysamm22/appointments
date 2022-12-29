package com.sesami.sesamiassignment.Exception;

import lombok.Data;

@Data
public class AppointmentValidationException extends RuntimeException{
    private int appointmentId;
    public AppointmentValidationException(String message, int appointmentId) {
        super(message);
        this.appointmentId = appointmentId;
    }
}