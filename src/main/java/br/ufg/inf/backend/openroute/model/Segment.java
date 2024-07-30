package br.ufg.inf.backend.openroute.model;

import lombok.Data;

import java.util.List;

@Data
public class Segment {
    private double distance;
    private double duration;
    private List<Step> steps;
}
