package com.matheuspierro.shipmonitoring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDateTime;

@Entity
public class HistoryShipLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long historyId;

    @NotNull(message = "Ship cannot be null")
    @ManyToOne
    @JoinColumn(name = "shipId")
    private Ship ship;

    @NotNull(message = "Location cannot be null")
    @ManyToOne
    @JoinColumn(name = "locationId")
    private Location location;

    @PastOrPresent(message = "Timestamp Date must be in the past or present")
    private LocalDateTime timestamp;

    public HistoryShipLocation() {
    }

    public HistoryShipLocation(Long historyId, Ship ship, Location location, LocalDateTime timestamp) {
        this.historyId = historyId;
        this.ship = ship;
        this.location = location;
        this.timestamp = timestamp;
    }

    public Long getHistoryId() {
        return historyId;
    }

    public HistoryShipLocation setHistoryId(Long historyId) {
        this.historyId = historyId;
        return this;
    }

    public Ship getShip() {
        return ship;
    }

    public HistoryShipLocation setShip(Ship ship) {
        this.ship = ship;
        return this;
    }

    public Location getLocation() {
        return location;
    }

    public HistoryShipLocation setLocation(Location location) {
        this.location = location;
        return this;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public HistoryShipLocation setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    @Override
    public String toString() {
        return "HistoryShipLocation{" +
                "historyId=" + historyId +
                ", ship=" + ship +
                ", location=" + location +
                ", timestamp=" + timestamp +
                '}';
    }
}