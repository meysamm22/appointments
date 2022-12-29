package com.sesami.sesamiassignment.Repository;

import com.sesami.sesamiassignment.Model.Appointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {
}
