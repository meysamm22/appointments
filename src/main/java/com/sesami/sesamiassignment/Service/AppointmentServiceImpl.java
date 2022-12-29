package com.sesami.sesamiassignment.Service;

import com.sesami.sesamiassignment.Dto.AppointmentDto;
import com.sesami.sesamiassignment.Model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService{

    @Autowired
    private AppointmentFactory factory;

    @Override
    public void process(List<Appointment> appointments) {

    }

    @Override
    public List<Appointment> list() {
        return null;
    }

    @Override
    public Appointment make(AppointmentDto dto) {
        return factory.make(dto);
    }
}
