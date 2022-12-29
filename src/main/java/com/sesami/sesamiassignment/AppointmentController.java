package com.sesami.sesamiassignment;

import com.sesami.sesamiassignment.Dto.AppointmentDto;
import com.sesami.sesamiassignment.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController @RequestMapping("api/appointments")
@Validated
public class AppointmentController {

    @Autowired
    private AppointmentService service;

    @PostMapping()
    public ResponseEntity<Void> process(@Valid @RequestBody List<AppointmentDto> appointmentDtos){
        service.process(
                appointmentDtos.stream().map(dto -> service.make(dto)).collect(Collectors.toList())
        );

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
