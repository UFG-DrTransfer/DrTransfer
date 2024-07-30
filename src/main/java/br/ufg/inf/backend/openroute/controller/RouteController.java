package br.ufg.inf.backend.openroute.controller;

import br.ufg.inf.backend.openroute.model.Summary;
import br.ufg.inf.backend.openroute.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

//@RestController
public class RouteController {
//
//    @Autowired
//    private RouteService routeService;
//
//    @GetMapping("/route")
//    public Mono<String> getRoute(
//            @RequestParam double startLon,
//            @RequestParam double startLat,
//            @RequestParam double endLon,
//            @RequestParam double endLat) {
//
//        return routeService.getRoute(startLon, startLat, endLon, endLat)
//                .map(route -> {
//                    Summary summary = route.getFeatures().get(0).getProperties().getSummary();
//                    double durationInMinutes = summary.getDurationInMinutes();
//                    double distanceInKilometers = summary.getDistanceInKilometers();
//
//                    return String.format("Tempo: %.2f minutes, Distancia: %.2f kilometers", durationInMinutes, distanceInKilometers);
//                });
//    }
//
//
//    @GetMapping("/route")
//    public Mono<String> getRoute(
//            @RequestParam double startLon,
//            @RequestParam double startLat,
//            @RequestParam double endLon,
//            @RequestParam double endLat) {
//
//        return routeService.getRoute(startLon, startLat, endLon, endLat)
//                .map(route -> {
//                    Summary summary = route.getFeatures().get(0).getProperties().getSummary();
//                    double durationInMinutes = summary.getDurationInMinutes();
//                    double distanceInKilometers = summary.getDistanceInKilometers();
//
//                    return String.format("Tempo: %.2f minutes, Distancia: %.2f kilometers", durationInMinutes, distanceInKilometers);
//                });
//    }
}
