package br.ufg.inf.backend.openroute.model;

import lombok.Data;

import java.util.List;

@Data
public class Route {
    private String type;
    private List<Feature> features;
}
