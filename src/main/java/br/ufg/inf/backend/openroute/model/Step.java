package br.ufg.inf.backend.openroute.model;

import lombok.Data;

import java.util.List;

@Data
public class Step {
    private double distance;
    private double duration;
    private int type;
    private String instruction;
    private String name;
    private List<Integer> way_points;
}
