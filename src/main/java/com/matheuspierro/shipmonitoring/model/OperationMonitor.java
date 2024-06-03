package com.matheuspierro.shipmonitoring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class OperationMonitor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long monitorId;

    @NotNull(message = "Ship cannot be null")
    @ManyToOne
    @JoinColumn(name = "shipId")
    private Ship ship;

    @NotNull(message = "Operation cannot be null")
    @ManyToOne
    @JoinColumn(name = "operationId")
    private BallastOperation operation;

    @NotBlank(message = "Metric Name Type cannot be blank")
    private String metricName;

    private BigDecimal metricValue;

    @PastOrPresent(message = "Metric Timestamp Date must be in the past or present")
    private LocalDateTime metricTimestamp;

    public OperationMonitor() {
    }

    public OperationMonitor(Long monitorId, Ship ship, BallastOperation operation, String metricName, BigDecimal metricValue, LocalDateTime metricTimestamp) {
        this.monitorId = monitorId;
        this.ship = ship;
        this.operation = operation;
        this.metricName = metricName;
        this.metricValue = metricValue;
        this.metricTimestamp = metricTimestamp;
    }

    public Long getMonitorId() {
        return monitorId;
    }

    public OperationMonitor setMonitorId(Long monitorId) {
        this.monitorId = monitorId;
        return this;
    }

    public Ship getShip() {
        return ship;
    }

    public OperationMonitor setShip(Ship ship) {
        this.ship = ship;
        return this;
    }

    public BallastOperation getOperation() {
        return operation;
    }

    public OperationMonitor setOperation(BallastOperation operation) {
        this.operation = operation;
        return this;
    }

    public String getMetricName() {
        return metricName;
    }

    public OperationMonitor setMetricName(String metricName) {
        this.metricName = metricName;
        return this;
    }

    public BigDecimal getMetricValue() {
        return metricValue;
    }

    public OperationMonitor setMetricValue(BigDecimal metricValue) {
        this.metricValue = metricValue;
        return this;
    }

    public LocalDateTime getMetricTimestamp() {
        return metricTimestamp;
    }

    public OperationMonitor setMetricTimestamp(LocalDateTime metricTimestamp) {
        this.metricTimestamp = metricTimestamp;
        return this;
    }

    @Override
    public String toString() {
        return "OperationMonitor{" +
                "monitorId=" + monitorId +
                ", ship=" + ship +
                ", operation=" + operation +
                ", metricName='" + metricName + '\'' +
                ", metricValue=" + metricValue +
                ", metricTimestamp=" + metricTimestamp +
                '}';
    }
}