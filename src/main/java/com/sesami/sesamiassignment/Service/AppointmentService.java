package com.sesami.sesamiassignment.Service;

import com.sesami.sesamiassignment.Dto.AppointmentDto;
import com.sesami.sesamiassignment.Model.Appointment;

import java.util.List;

public interface AppointmentService {
    List<String> process(List<Appointment> appointments);
    List<Appointment> list();

    Appointment make(AppointmentDto dto);
}
