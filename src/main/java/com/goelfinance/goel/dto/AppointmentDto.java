package com.goelfinance.goel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AppointmentDto {
    private Long appointmentId;
    private String fullName;
    private String email;
    private String date;
    private String time;
    private String address;
    private String message;

}
