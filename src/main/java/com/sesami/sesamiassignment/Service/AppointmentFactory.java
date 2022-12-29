package com.sesami.sesamiassignment.Service;

import com.sesami.sesamiassignment.Dto.AppointmentDto;
import com.sesami.sesamiassignment.Model.Appointment;
import org.springframework.stereotype.Service;

@Service
public class AppointmentFactory {
    protected Appointment make(AppointmentDto dto){
        return new Appointment(
                dto.getId(),
                dto.getStart(),
                dto.getEnd(),
                dto.getCreatedAt(),
                dto.getUpdateAt()
        );
    }
}
