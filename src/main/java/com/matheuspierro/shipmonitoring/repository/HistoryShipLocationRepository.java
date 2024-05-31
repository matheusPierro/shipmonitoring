package com.matheuspierro.shipmonitoring.repository;

import com.matheuspierro.shipmonitoring.model.HistoryShipLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryShipLocationRepository extends JpaRepository<HistoryShipLocation, Long> {
}