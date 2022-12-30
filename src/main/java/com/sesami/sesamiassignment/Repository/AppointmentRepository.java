package com.sesami.sesamiassignment.Repository;

import com.sesami.sesamiassignment.Model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
    Optional<Appointment> findTopByStartAndEnd(Date start, Date end);
    @Query(value = "select * from appointment u where (u.start <= :start and u.end >= :start) or (u.start <= :end and u.end >= :end) or (u.start >= :start and u.end <= :end) limit 1", nativeQuery = true)
    Optional<Appointment> findConflicts(@Param("start") Date start, @Param("end") Date end);
    List<Appointment> findAllByStartGreaterThanEqualAndEndIsLessThanEqual(Date start, Date end);

}
