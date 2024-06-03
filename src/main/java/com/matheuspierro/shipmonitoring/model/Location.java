package com.matheuspierro.shipmonitoring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long locationId;

    private BigDecimal lat;
    private BigDecimal lon;

    public Location() {
    }

    public Location(Long locationId, BigDecimal lat, BigDecimal lon) {
        this.locationId = locationId;
        this.lat = lat;
        this.lon = lon;
    }

    public Long getLocationId() {
        return locationId;
    }

    public Location setLocationId(Long locationId) {
        this.locationId = locationId;
        return this;
    }

    public BigDecimal getLat() {
        return lat;
    }

    public Location setLat(BigDecimal lat) {
        this.lat = lat;
        return this;
    }

    public BigDecimal getLon() {
        return lon;
    }

    public Location setLon(BigDecimal lon) {
        this.lon = lon;
        return this;
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationId=" + locationId +
                ", lat=" + lat +
                ", lon=" + lon +
                '}';
    }
}
