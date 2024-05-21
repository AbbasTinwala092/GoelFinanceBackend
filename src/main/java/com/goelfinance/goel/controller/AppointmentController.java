package com.goelfinance.goel.controller;

import com.goelfinance.goel.dto.AppointmentDto;
import com.goelfinance.goel.dto.ClientDto;
import com.goelfinance.goel.service.AppointmentService;
import com.goelfinance.goel.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {
    private AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public ResponseEntity<AppointmentDto> addAppointment(@RequestBody AppointmentDto appointmentDto){
        return new ResponseEntity<>(appointmentService.createAppointment(appointmentDto), HttpStatus.CREATED);
    }
}
