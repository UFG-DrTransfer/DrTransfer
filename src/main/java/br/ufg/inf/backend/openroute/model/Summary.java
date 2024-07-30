package br.ufg.inf.backend.openroute.model;

import lombok.Data;

@Data
public class Summary {
    private double distance;
    private double duration;

    public double getDurationInMinutes() {
        return duration / 60.0;
    }

    public double getDistanceInKilometers() {
        return distance / 1000.0;
    }
}
