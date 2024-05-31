package com.matheuspierro.shipmonitoring.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class HistoryShipLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long historyId;

    @ManyToOne
    @JoinColumn(name = "shipId")
    private Ship ship;

    @ManyToOne
    @JoinColumn(name = "locationId")
    private Location location;

    private LocalDateTime timestamp;
}