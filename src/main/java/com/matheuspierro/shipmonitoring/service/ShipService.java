package com.matheuspierro.shipmonitoring.service;

import com.matheuspierro.shipmonitoring.exception.ServiceException;
import com.matheuspierro.shipmonitoring.model.Ship;
import com.matheuspierro.shipmonitoring.repository.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ShipService {
    @Autowired
    private ShipRepository shipRepository;

    public List<Ship> getAllShips() {
        try {
            return shipRepository.findAll();
        } catch (Exception e) {
            throw new ServiceException("Error fetching all ships", e);
        }
    }

    public Ship saveShip(Ship ship) {
        try {
            return shipRepository.save(ship);
        } catch (Exception e) {
            throw new ServiceException("Error saving ship", e);
        }
    }
}
