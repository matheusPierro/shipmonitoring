package com.matheuspierro.shipmonitoring.controller;

import com.matheuspierro.shipmonitoring.model.Ship;
import com.matheuspierro.shipmonitoring.service.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ships")
public class ShipController {
    @Autowired
    private ShipService shipService;

    @GetMapping
    public List<Ship> getAllShips() {
        return shipService.getAllShips();
    }

    @PostMapping
    public Ship saveShip(@RequestBody Ship ship) {
        return shipService.saveShip(ship);
    }
}
