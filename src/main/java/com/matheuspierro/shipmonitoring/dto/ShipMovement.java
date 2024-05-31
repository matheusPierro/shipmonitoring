package com.matheuspierro.shipmonitoring.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public record ShipMovement(
        Long shipId,
        String shipName,
        String operationType,
        LocalDateTime timestamp,
        BigDecimal latitude,
        BigDecimal longitude,
        BigDecimal waterAmount
) {}
