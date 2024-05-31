package com.matheuspierro.shipmonitoring.service;

import com.matheuspierro.shipmonitoring.dto.ShipMovement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ExternalApiService {

    private final RestTemplate restTemplate;
    private final String apiUrl;

    public ExternalApiService(RestTemplate restTemplate, @Value("${external.api.url}") String apiUrl) {
        this.restTemplate = restTemplate;
        this.apiUrl = apiUrl;
    }

    public List<ShipMovement> fetchShipMovements() {
        ShipMovement[] movements = restTemplate.getForObject(apiUrl, ShipMovement[].class);
        assert movements != null;
        return Arrays.asList(movements);
    }
}