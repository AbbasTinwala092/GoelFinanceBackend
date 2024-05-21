package com.goelfinance.goel.service.impl;

import com.goelfinance.goel.dto.AppointmentDto;
import com.goelfinance.goel.entity.Appointment;
import com.goelfinance.goel.entity.Client;
import com.goelfinance.goel.mapper.AppointmentMapper;
import com.goelfinance.goel.mapper.ClientMapper;
import com.goelfinance.goel.repository.AppointmentRepository;
import com.goelfinance.goel.repository.ClientRepository;
import com.goelfinance.goel.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;


    @Override
    public AppointmentDto createAppointment(AppointmentDto appointmentDto) {
        Appointment appointment = AppointmentMapper.mapToAppointment(appointmentDto);
        Appointment savedAppointment = appointmentRepository.save(appointment);
        return AppointmentMapper.mapToAppointmentDto(savedAppointment);
    }
}
