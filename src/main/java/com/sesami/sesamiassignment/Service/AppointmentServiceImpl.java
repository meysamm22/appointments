package com.sesami.sesamiassignment.Service;

import com.sesami.sesamiassignment.Dto.AppointmentDto;
import com.sesami.sesamiassignment.Exception.AppointmentValidationException;
import com.sesami.sesamiassignment.Model.Appointment;
import com.sesami.sesamiassignment.Repository.AppointmentRepository;
import com.sesami.sesamiassignment.Service.Validation.AppointmentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;


@Service
public class AppointmentServiceImpl implements AppointmentService{

    @Autowired
    private AppointmentFactory factory;

    @Autowired
    private AppointmentRepository repository;

    @Autowired
    private AppointmentValidator validator;

    private static Lock lock = new ReentrantLock();

    @Override
    public List<String> process(Appointment appointment) {
        lock.lock();
        List<String> result = new ArrayList<>();
            try {
                validator.validate(appointment);
                repository.save(appointment);
                result.add("The new appointment is Added!");
            }catch (AppointmentValidationException e){
                result.add( "Appointment (" + appointment.getStart() + " To "+ appointment.getEnd() + ") is NOT added because of: " + e.getMessage());
            }

        lock.unlock();
        return result;
    }

    @Override
    public List<AppointmentDto> list(Date start, Date end) {
        List<Appointment> appointments = repository.findAllByStartGreaterThanEqualAndEndIsLessThanEqual(start, end);
        return mapToDtoList(appointments);
    }

    private static List<AppointmentDto> mapToDtoList(List<Appointment> appointments) {
        return appointments.stream().map(appointment ->
                new AppointmentDto(
                        appointment.getId(),
                        appointment.getStart(),
                        appointment.getEnd(),
                        appointment.getCreatedAt(),
                        appointment.getUpdatedAt()
                )
        ).collect(Collectors.toList());
    }

    @Override
    public Appointment make(AppointmentDto dto) {
        return factory.make(dto);
    }
}
