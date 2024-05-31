package com.matheuspierro.shipmonitoring.repository;

import com.matheuspierro.shipmonitoring.model.OperationMonitor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationMonitorRepository extends JpaRepository<OperationMonitor, Long> {
}