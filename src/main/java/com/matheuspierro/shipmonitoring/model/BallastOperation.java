package com.matheuspierro.shipmonitoring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class BallastOperation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long operationId;

    @NotNull(message = "Ship cannot be null")
    @ManyToOne
    @JoinColumn(name = "shipId")
    private Ship ship;

    @NotNull(message = "Location cannot be null")
    @ManyToOne
    @JoinColumn(name = "locationId")
    private Location location;

    @NotBlank(message = "Operation Type cannot be blank")
    private String operationType;

    @PastOrPresent(message = "Operation Timestamp Date must be in the past or present")
    private LocalDateTime operationTimestamp;

    @Min(value = 0, message = "Water Amount must be at least 0")
    private BigDecimal waterAmount;

    public BallastOperation() {
    }

    public BallastOperation(Long operationId, Ship ship, Location location, String operationType, LocalDateTime operationTimestamp, BigDecimal waterAmount) {
        this.operationId = operationId;
        this.ship = ship;
        this.location = location;
        this.operationType = operationType;
        this.operationTimestamp = operationTimestamp;
        this.waterAmount = waterAmount;
    }

    public Long getOperationId() {
        return operationId;
    }

    public BallastOperation setOperationId(Long operationId) {
        this.operationId = operationId;
        return this;
    }

    public Ship getShip() {
        return ship;
    }

    public BallastOperation setShip(Ship ship) {
        this.ship = ship;
        return this;
    }

    public Location getLocation() {
        return location;
    }

    public BallastOperation setLocation(Location location) {
        this.location = location;
        return this;
    }

    public String getOperationType() {
        return operationType;
    }

    public BallastOperation setOperationType(String operationType) {
        this.operationType = operationType;
        return this;
    }

    public LocalDateTime getOperationTimestamp() {
        return operationTimestamp;
    }

    public BallastOperation setOperationTimestamp(LocalDateTime operationTimestamp) {
        this.operationTimestamp = operationTimestamp;
        return this;
    }

    public BigDecimal getWaterAmount() {
        return waterAmount;
    }

    public BallastOperation setWaterAmount(BigDecimal waterAmount) {
        this.waterAmount = waterAmount;
        return this;
    }

    @Override
    public String toString() {
        return "BallastOperation{" +
                "operationId=" + operationId +
                ", ship=" + ship +
                ", location=" + location +
                ", operationType='" + operationType + '\'' +
                ", operationTimestamp=" + operationTimestamp +
                ", waterAmount=" + waterAmount +
                '}';
    }
}
