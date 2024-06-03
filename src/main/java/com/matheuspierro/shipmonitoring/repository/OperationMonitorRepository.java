package com.matheuspierro.shipmonitoring.repository;

import com.matheuspierro.shipmonitoring.model.OperationMonitor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OperationMonitorRepository extends JpaRepository<OperationMonitor, Long> {
    Optional<OperationMonitor> findByShipName(String shipName);
}