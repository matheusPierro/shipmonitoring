package com.matheuspierro.shipmonitoring.service;

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
        return shipRepository.findAll();
    }

    public Ship saveShip(Ship ship) {
        return shipRepository.save(ship);
    }
}
