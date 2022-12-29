package com.sesami.sesamiassignment.Service.Validation;

import com.sesami.sesamiassignment.Repository.AppointmentRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service @NoArgsConstructor
public class BaseValidator {
    @Autowired
    protected AppointmentRepository repository;

}
