package com.matheuspierro.shipmonitoring.controller;

import com.matheuspierro.shipmonitoring.model.HistoryShipLocation;
import com.matheuspierro.shipmonitoring.service.HistoryShipLocationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/history")
public class HistoryShipLocationController {
    @Autowired
    private HistoryShipLocationService historyShipLocationService;

    @GetMapping
    public Page<HistoryShipLocation> getAllHistory(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {
        return historyShipLocationService.getAllHistory(page, size);
    }

    @PostMapping
    public HistoryShipLocation saveHistory(@Valid @RequestBody HistoryShipLocation history) {
        return historyShipLocationService.saveHistory(history);
    }
}
