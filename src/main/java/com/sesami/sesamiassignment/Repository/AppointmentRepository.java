package com.sesami.sesamiassignment.Repository;

import com.sesami.sesamiassignment.Model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
    Optional<Appointment> findByStartAndEnd(Date start, Date end);
}
