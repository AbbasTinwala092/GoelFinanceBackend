package com.goelfinance.goel.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="sips")
@Entity
public class Sip {
    @Id
    @Column(name="sip_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sipId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id", referencedColumnName = "client_id")
    private Client client;

    private String title;

    @Column(name="cap_fund")
    private String capFund;
    private Integer value;

    @Column(name="start_date")
    private String startDate;
}