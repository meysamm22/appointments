package com.sesami.sesamiassignment.Repository;

import com.sesami.sesamiassignment.Model.Appointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {
    Optional<Appointment> findByStartAndEnd(Date start, Date end);
}
