package com.sesami.sesamiassignment;

import com.sesami.sesamiassignment.Dto.AppointmentDto;
import com.sesami.sesamiassignment.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService service;

    @PostMapping()
    public void process(@RequestBody List<AppointmentDto> appointmentDtos){

    }
}
