package com.matheuspierro.shipmonitoring.service;

import com.matheuspierro.shipmonitoring.dto.ShipMovement;
import com.matheuspierro.shipmonitoring.exception.ServiceException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
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
        try {
            ShipMovement[] movements = restTemplate.getForObject(apiUrl, ShipMovement[].class);
            if (movements == null) {
                throw new ServiceException("No ship movements found");
            }
            return Arrays.asList(movements);
        } catch (RestClientException e) {
            throw new ServiceException("Error fetching ship movements from external API", e);
        }
    }
}