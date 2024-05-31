package com.matheuspierro.shipmonitoring.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class OperationMonitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long monitorId;

    @ManyToOne
    @JoinColumn(name = "shipId")
    private Ship ship;

    @ManyToOne
    @JoinColumn(name = "operationId")
    private BallastOperation operation;

    private String metricName;
    private BigDecimal metricValue;
    private LocalDateTime metricTimestamp;
}