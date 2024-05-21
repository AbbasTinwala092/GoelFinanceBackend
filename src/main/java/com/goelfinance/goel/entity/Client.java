package com.goelfinance.goel.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="clients")
@Entity
public class Client {
    @Id
    @Column(name="client_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;

    @Column(name = "full_name")
    private String fullName;

    private Integer age;
    private String address;
    private Integer income;

    @Column(name = "contact_number")
    private Long contactNumber;
    private String email;
    private String occupation;

    @Column(name = "pan_number")
    private String panNumber;
    private String dob;

}
