package com.sesami.sesamiassignment.Service;

import com.sesami.sesamiassignment.Dto.AppointmentDto;
import com.sesami.sesamiassignment.Model.Appointment;

import java.util.Date;
import java.util.List;

public interface AppointmentService {
    List<String> process(List<Appointment> appointments);
    List<AppointmentDto> list(Date start, Date end);

    Appointment make(AppointmentDto dto);
}
