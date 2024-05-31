package com.matheuspierro.shipmonitoring.controller;

import com.matheuspierro.shipmonitoring.model.HistoryShipLocation;
import com.matheuspierro.shipmonitoring.service.HistoryShipLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/history")
public class HistoryShipLocationController {
    @Autowired
    private HistoryShipLocationService historyShipLocationService;

    @GetMapping
    public List<HistoryShipLocation> getAllHistory() {
        return historyShipLocationService.getAllHistory();
    }

    @PostMapping
    public HistoryShipLocation saveHistory(@RequestBody HistoryShipLocation history) {
        return historyShipLocationService.saveHistory(history);
    }
}
