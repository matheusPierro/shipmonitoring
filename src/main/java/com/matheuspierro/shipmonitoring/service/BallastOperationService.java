package com.matheuspierro.shipmonitoring.service;

import com.matheuspierro.shipmonitoring.model.BallastOperation;
import com.matheuspierro.shipmonitoring.repository.BallastOperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BallastOperationService {
    @Autowired
    private BallastOperationRepository ballastOperationRepository;

    public List<BallastOperation> getAllOperations() {
        return ballastOperationRepository.findAll();
    }

    public BallastOperation saveOperation(BallastOperation operation) {
        return ballastOperationRepository.save(operation);
    }
}
