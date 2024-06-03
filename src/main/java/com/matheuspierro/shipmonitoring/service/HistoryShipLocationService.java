package com.matheuspierro.shipmonitoring.service;

import com.matheuspierro.shipmonitoring.exception.ServiceException;
import com.matheuspierro.shipmonitoring.model.HistoryShipLocation;
import com.matheuspierro.shipmonitoring.repository.HistoryShipLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class HistoryShipLocationService {
    @Autowired
    private HistoryShipLocationRepository historyShipLocationRepository;

    public Page<HistoryShipLocation> getAllHistory(int page, int size) {
        try {
            Pageable pageable = PageRequest.of(page, size);
            return historyShipLocationRepository.findAll(pageable);
        } catch (Exception e) {
            throw new ServiceException("Error fetching history", e);
        }
    }

    public HistoryShipLocation saveHistory(HistoryShipLocation history) {
        try {
            return historyShipLocationRepository.save(history);
        } catch (Exception e) {
            throw new ServiceException("Error saving history", e);
        }
    }
}
