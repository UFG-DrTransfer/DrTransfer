package br.ufg.inf.backend.openroute.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import br.ufg.inf.backend.openroute.OpenRouteServiceConfig;
import br.ufg.inf.backend.openroute.model.Route;

@Service
public class RouteService {

    private final WebClient webClient;
    private final OpenRouteServiceConfig config;

    @Autowired
    public RouteService(WebClient.Builder webClientBuilder, OpenRouteServiceConfig config) {
        this.webClient = webClientBuilder.baseUrl("https://api.openrouteservice.org").build();
        this.config = config;
    }

    public Mono<Route> getRoute(double startLon, double startLat, double endLon, double endLat) {
        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/v2/directions/driving-car")
                        .queryParam("api_key", config.getApiKey())
                        .queryParam("start", startLon + "," + startLat)
                        .queryParam("end", endLon + "," + endLat)
                        .build())
                .retrieve()
                .bodyToMono(Route.class);
    }
}
