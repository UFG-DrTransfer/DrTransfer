package br.ufg.inf.backend.drtransfer.service;

import br.ufg.inf.backend.drtransfer.model.apirota.OpenRouteServiceResponse;
import br.ufg.inf.backend.drtransfer.model.apirota.Summary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class RouteService {

    @Value("${openrouteservice.api.key}")
    private String apiKey;

    public Map<String, Long> getRoute(double startLat, double startLon, double endLat, double endLon) {
        String url = String.format(
                "https://api.openrouteservice.org/v2/directions/driving-car?api_key=%s&start=%s,%s&end=%s,%s",
                apiKey, startLon, startLat, endLon, endLat
        );

        RestTemplate restTemplate = new RestTemplate();
        OpenRouteServiceResponse response = restTemplate.getForObject(url, OpenRouteServiceResponse.class);

        if (response != null && response.getFeatures() != null && response.getFeatures().length > 0) {
            Map<String, Long> params = new HashMap<>();
            Summary summary = response.getFeatures()[0].getProperties().getSummary();
            params.put("distancia", (long) summary.getDistance());
            params.put("duracao", (long) summary.getDuration());
            return params;
        } else {
            return null;
        }
    }
}
