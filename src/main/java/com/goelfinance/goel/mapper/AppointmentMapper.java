package com.goelfinance.goel.mapper;

import com.goelfinance.goel.dto.AppointmentDto;
import com.goelfinance.goel.entity.Appointment;

public class AppointmentMapper {
    public static Appointment mapToAppointment(AppointmentDto appointmentDto){
        return new Appointment(
                appointmentDto.getAppointmentId(),
                appointmentDto.getFullName(),
                appointmentDto.getEmail(),
                appointmentDto.getDate(),
                appointmentDto.getTime(),
                appointmentDto.getAddress(),
                appointmentDto.getMessage()
        );
    }

    public static AppointmentDto mapToAppointmentDto(Appointment appointment){
        return new AppointmentDto(
                appointment.getAppointmentId(),
                appointment.getFullName(),
                appointment.getEmail(),
                appointment.getDate(),
                appointment.getTime(),
                appointment.getAddress(),
                appointment.getMessage()
        );
    }
}
