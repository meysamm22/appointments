package com.sesami.sesamiassignment.Service;

import com.sesami.sesamiassignment.Model.Appointment;

import java.util.List;

public interface AppointmentService {
    void process();
    List<Appointment> list();
}
