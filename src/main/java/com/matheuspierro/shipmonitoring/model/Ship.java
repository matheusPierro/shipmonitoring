package com.matheuspierro.shipmonitoring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

@Entity
public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shipId;

    @NotBlank(message = "Name Ship cannot be blank")
    private String name;

    @NotBlank(message = "Ship Type cannot be blank")
    private String shipType;

    @Min(value = 0, message = "Ballast Capacity must be at least 0")
    private BigDecimal ballastCapacity;

    public Ship() {
    }

    public Ship(Long shipId, String name, String shipType, BigDecimal ballastCapacity) {
        this.shipId = shipId;
        this.name = name;
        this.shipType = shipType;
        this.ballastCapacity = ballastCapacity;
    }

    public Long getShipId() {
        return shipId;
    }

    public Ship setShipId(Long shipId) {
        this.shipId = shipId;
        return this;
    }

    public String getName() {
        return name;
    }

    public Ship setName(String name) {
        this.name = name;
        return this;
    }

    public String getShipType() {
        return shipType;
    }

    public Ship setShipType(String shipType) {
        this.shipType = shipType;
        return this;
    }

    public BigDecimal getBallastCapacity() {
        return ballastCapacity;
    }

    public Ship setBallastCapacity(BigDecimal ballastCapacity) {
        this.ballastCapacity = ballastCapacity;
        return this;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "shipId=" + shipId +
                ", name='" + name + '\'' +
                ", shipType='" + shipType + '\'' +
                ", ballastCapacity=" + ballastCapacity +
                '}';
    }
}
