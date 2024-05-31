package com.matheuspierro.shipmonitoring.service;

import com.matheuspierro.shipmonitoring.model.OperationMonitor;
import com.matheuspierro.shipmonitoring.repository.OperationMonitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationMonitorService {
    @Autowired
    private OperationMonitorRepository operationMonitorRepository;

    public List<OperationMonitor> getAllMetrics() {
        return operationMonitorRepository.findAll();
    }

    public OperationMonitor saveMetric(OperationMonitor metric) {
        return operationMonitorRepository.save(metric);
    }
}
