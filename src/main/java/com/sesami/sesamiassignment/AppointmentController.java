package com.sesami.sesamiassignment;

import com.sesami.sesamiassignment.Dto.AppointmentDto;
import com.sesami.sesamiassignment.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController @RequestMapping("api/appointments")
@Validated
public class AppointmentController {

    @Autowired
    private AppointmentService service;

    @PostMapping()
    public ResponseEntity<List<String>> process(@Valid @RequestBody AppointmentDto appointmentDtos){
        List<String> result = service.process(service.make(appointmentDtos));

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<AppointmentDto>> list(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") Date start, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") Date end){
        return new ResponseEntity<>(service.list(start, end), HttpStatus.OK);
    }

}
