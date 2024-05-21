package com.goelfinance.goel.dto;

import com.goelfinance.goel.entity.Sip;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@AllArgsConstructor
public class ClientDto {
    private Long clientId;
    private String fullName;
    private Integer age;
    private String address;
    private Integer income;
    private Long contactNumber;
    private String email;
    private String occupation;
    private String panNumber;
    private String dob;
}
