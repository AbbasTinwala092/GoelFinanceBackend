package com.goelfinance.goel.dto;

import com.goelfinance.goel.entity.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
public class SipDto {
    private Long sipId;
    private Long clientId;
    private String title;
    private String capFund;
    private Integer value;
    private String startDate;
}
