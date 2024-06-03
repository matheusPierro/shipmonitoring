package com.matheuspierro.shipmonitoring.controller;

import com.matheuspierro.shipmonitoring.model.BallastOperation;
import com.matheuspierro.shipmonitoring.service.BallastOperationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/operations")
public class BallastOperationController {
    @Autowired
    private BallastOperationService ballastOperationService;

    @GetMapping
    public List<BallastOperation> getAllOperations() {
        return ballastOperationService.getAllOperations();
    }

    @PostMapping
    public BallastOperation saveOperation(@Valid @RequestBody BallastOperation operation) {
        return ballastOperationService.saveOperation(operation);
    }
}
