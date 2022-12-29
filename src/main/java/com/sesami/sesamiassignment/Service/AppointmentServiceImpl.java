package com.sesami.sesamiassignment.Service;

import com.sesami.sesamiassignment.Dto.AppointmentDto;
import com.sesami.sesamiassignment.Exception.AppointmentExistsException;
import com.sesami.sesamiassignment.Exception.AppointmentValidationException;
import com.sesami.sesamiassignment.Model.Appointment;
import com.sesami.sesamiassignment.Repository.AppointmentRepository;
import com.sesami.sesamiassignment.Service.Validation.AppointmentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService{

    @Autowired
    private AppointmentFactory factory;

    @Autowired
    private AppointmentRepository repository;

    @Autowired
    private AppointmentValidator validator;

    @Override
    public HashMap<Integer,String> process(List<Appointment> appointments) {
        HashMap<Integer,String> result = new HashMap<>();
        for (Appointment appointment: appointments) {
            try {
                validator.validate(appointment);
                result.put(appointment.getId(), "Appointment#" +appointment.getId() + " Added!");
            }catch (AppointmentValidationException e){
                result.put(appointment.getId(), "Appointment#" +e.getAppointmentId() + " is NOT added because of: " + e.getMessage());
            }
        }
        repository.saveAll(appointments);

        return result;
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
