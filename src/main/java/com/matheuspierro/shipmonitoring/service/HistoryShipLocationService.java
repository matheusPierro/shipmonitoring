package com.matheuspierro.shipmonitoring.service;

import com.matheuspierro.shipmonitoring.model.HistoryShipLocation;
import com.matheuspierro.shipmonitoring.repository.HistoryShipLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryShipLocationService {
    @Autowired
    private HistoryShipLocationRepository historyShipLocationRepository;

    public List<HistoryShipLocation> getAllHistory() {
        return historyShipLocationRepository.findAll();
    }

    public HistoryShipLocation saveHistory(HistoryShipLocation history) {
        return historyShipLocationRepository.save(history);
    }
}
