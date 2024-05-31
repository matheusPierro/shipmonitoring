package com.matheuspierro.shipmonitoring.service;

import com.matheuspierro.shipmonitoring.dto.ShipMovement;
import com.matheuspierro.shipmonitoring.model.Ship;
import com.matheuspierro.shipmonitoring.model.Location;
import com.matheuspierro.shipmonitoring.model.BallastOperation;
import com.matheuspierro.shipmonitoring.repository.ShipRepository;
import com.matheuspierro.shipmonitoring.repository.LocationRepository;
import com.matheuspierro.shipmonitoring.repository.BallastOperationRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UpdateService {

    @Autowired
    private ExternalApiService externalApiService;
    @Autowired
    private ShipRepository shipRepository;
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private BallastOperationRepository ballastOperationRepository;

    public void updateShipData() {
        List<ShipMovement> movements = externalApiService.fetchShipMovements();
        for (ShipMovement movement : movements) {
            Ship ship = shipRepository.findByName(movement.shipName()).orElseGet(() -> {
                Ship newShip = new Ship();
                newShip.setName(movement.shipName());

//            ship.setShipType(movement.shipType());
//            ship.setBallastCapacity(movement.ballastCapacity());

                return newShip;
            });
            shipRepository.save(ship);

            Location location = new Location();
            location.setLat(movement.latitude());
            location.setLon(movement.longitude());
            locationRepository.save(location);

            BallastOperation operation = new BallastOperation();
            operation.setShip(ship);
            operation.setLocation(location);
            operation.setOperationType(movement.operationType());
            operation.setOperationTimestamp(movement.timestamp());
            operation.setWaterAmount(movement.waterAmount());
            ballastOperationRepository.save(operation);
        }
    }
}
