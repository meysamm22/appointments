package com.sesami.sesamiassignment.Service;

import com.sesami.sesamiassignment.Dto.AppointmentDto;
import com.sesami.sesamiassignment.Model.Appointment;
import com.sesami.sesamiassignment.Repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentFactory {

    @Autowired
    private AppointmentRepository repository;

    protected Appointment make(AppointmentDto dto){
        Appointment appointment;
        appointment = repository.findById(dto.getId()).orElse(new Appointment());
        appointment.setStart(dto.getStart());
        appointment.setEnd(dto.getEnd());
        appointment.setCreatedAt(dto.getCreatedAt());
        appointment.setUpdatedAt(dto.getUpdatedAt());

        return appointment;
    }
}
