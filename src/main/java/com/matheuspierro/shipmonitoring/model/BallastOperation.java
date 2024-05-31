package com.matheuspierro.shipmonitoring.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class BallastOperation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long operationId;

    @ManyToOne
    @JoinColumn(name = "shipId")
    private Ship ship;

    @ManyToOne
    @JoinColumn(name = "locationId")
    private Location location;

    private String operationType;
    private LocalDateTime operationTimestamp;
    private BigDecimal waterAmount;
}
