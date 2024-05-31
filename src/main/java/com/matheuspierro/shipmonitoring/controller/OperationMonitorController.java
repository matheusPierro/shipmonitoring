package com.matheuspierro.shipmonitoring.controller;

import com.matheuspierro.shipmonitoring.model.OperationMonitor;
import com.matheuspierro.shipmonitoring.service.OperationMonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/metrics")
public class OperationMonitorController {
    @Autowired
    private OperationMonitorService operationMonitorService;

    @GetMapping
    public List<OperationMonitor> getAllMetrics() {
        return operationMonitorService.getAllMetrics();
    }

    @PostMapping
    public OperationMonitor saveMetric(@RequestBody OperationMonitor metric) {
        return operationMonitorService.saveMetric(metric);
    }
}
