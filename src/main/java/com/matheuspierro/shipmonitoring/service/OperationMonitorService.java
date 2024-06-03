package com.matheuspierro.shipmonitoring.service;

import com.matheuspierro.shipmonitoring.exception.ServiceException;
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
        try {
            return operationMonitorRepository.findAll();
        } catch (Exception e) {
            throw new ServiceException("Error fetching all metrics", e);
        }
    }

    public OperationMonitor saveMetric(OperationMonitor metric) {
        try {
            return operationMonitorRepository.save(metric);
        } catch (Exception e) {
            throw new ServiceException("Error saving metric", e);
        }
    }
}
