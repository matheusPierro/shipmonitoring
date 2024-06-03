package com.matheuspierro.shipmonitoring.service;

import com.matheuspierro.shipmonitoring.exception.ServiceException;
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
        try {
            return ballastOperationRepository.findAll();
        } catch (Exception e) {
            throw new ServiceException("Error fetching all ballast operations", e);
        }
    }

    public BallastOperation saveOperation(BallastOperation operation) {
        try {
            return ballastOperationRepository.save(operation);
        } catch (Exception e) {
            throw new ServiceException("Error saving ballast operation", e);
        }
    }
}
