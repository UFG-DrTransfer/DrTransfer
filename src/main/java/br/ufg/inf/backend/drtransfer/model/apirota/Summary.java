package br.ufg.inf.backend.drtransfer.model.apirota;

import lombok.Data;
import lombok.NonNull;

@Data
public class Summary {
    @NonNull
    private double distance;
    @NonNull
    private double duration;
}
