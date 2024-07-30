package br.ufg.inf.backend.openroute.model;

import lombok.Data;

@Data
public class Feature {
    private String type;
    private Geometry geometry;
    private Properties properties;
}
