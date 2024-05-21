package com.goelfinance.goel.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="appointments")
@Entity
public class Appointment {
    @Id
    @Column(name="appointment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;
    @Column(name = "full_name")
    private String fullName;
    private String email;
    private String date;
    private String time;
    private String address;
    private String message;
}
