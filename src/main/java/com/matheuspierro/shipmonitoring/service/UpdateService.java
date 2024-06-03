package com.matheuspierro.shipmonitoring.service;

import com.matheuspierro.shipmonitoring.dto.ShipMovement;
import com.matheuspierro.shipmonitoring.exception.ServiceException;
import com.matheuspierro.shipmonitoring.model.BallastOperation;
import com.matheuspierro.shipmonitoring.model.HistoryShipLocation;
import com.matheuspierro.shipmonitoring.model.Location;
import com.matheuspierro.shipmonitoring.model.OperationMonitor;
import com.matheuspierro.shipmonitoring.model.Ship;
import com.matheuspierro.shipmonitoring.repository.BallastOperationRepository;
import com.matheuspierro.shipmonitoring.repository.HistoryShipLocationRepository;
import com.matheuspierro.shipmonitoring.repository.LocationRepository;
import com.matheuspierro.shipmonitoring.repository.OperationMonitorRepository;
import com.matheuspierro.shipmonitoring.repository.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    @Autowired
    private HistoryShipLocationRepository historyShipLocationRepository;
    @Autowired
    private OperationMonitorRepository operationMonitorRepository;

    public void updateShipData() {
        List<ShipMovement> movements;
        try {
            movements = externalApiService.fetchShipMovements();
        } catch (Exception e) {
            throw new ServiceException("Error fetching ship movements from external API", e);
        }

        for (ShipMovement movement : movements) {
            Ship ship;
            try {
                ship = shipRepository.findByName(movement.shipName()).orElseGet(() -> {
                    Ship newShip = new Ship();
                    newShip.setName(movement.shipName());
                    return newShip;
                });
                shipRepository.save(ship);
            } catch (Exception e) {
                throw new ServiceException("Error saving ship data", e);
            }

            Location location = new Location();
            location.setLat(movement.latitude());
            location.setLon(movement.longitude());
            try {
                locationRepository.save(location);
            } catch (Exception e) {
                throw new ServiceException("Error saving location data", e);
            }

            BallastOperation operation = new BallastOperation();
            operation.setShip(ship);
            operation.setLocation(location);
            operation.setOperationType(movement.operationType());
            operation.setOperationTimestamp(movement.timestamp());
            operation.setWaterAmount(movement.waterAmount());
            try {
                ballastOperationRepository.save(operation);
            } catch (Exception e) {
                throw new ServiceException("Error saving ballast operation data", e);
            }

            HistoryShipLocation history = new HistoryShipLocation();
            history.setShip(ship);
            history.setLocation(location);
            history.setTimestamp(movement.timestamp());
            try {
                historyShipLocationRepository.save(history);
            } catch (Exception e) {
                throw new ServiceException("Error saving history ship location data", e);
            }

            OperationMonitor monitor;
            try {
                monitor = operationMonitorRepository.findByShipName(ship.getName()).orElseGet(() -> {
                    OperationMonitor newMonitor = new OperationMonitor();
                    newMonitor.setShip(ship);
                    newMonitor.setOperation(operation);
                    newMonitor.setMetricName("Operation Metric");
                    newMonitor.setMetricValue(movement.waterAmount());
                    newMonitor.setMetricTimestamp(movement.timestamp());
                    return newMonitor;
                });
                monitor.setMetricValue(movement.waterAmount());
                monitor.setMetricTimestamp(movement.timestamp());
                operationMonitorRepository.save(monitor);
            } catch (Exception e) {
                throw new ServiceException("Error saving operation monitor data", e);
            }
        }
    }
}
