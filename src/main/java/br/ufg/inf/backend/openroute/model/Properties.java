package br.ufg.inf.backend.openroute.model;

import lombok.Data;

import java.util.List;

@Data
public class Properties {
    private List<Segment> segments;
    private Summary summary;
}
