package com.matheuspierro.shipmonitoring.dto;

import java.math.BigDecimal;

public record ShipDto(
        Long id,
        String name,
        String shipType,
        BigDecimal ballastCapacity
) {}
