package br.ufg.inf.backend.drtransfer.enumeradores;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MeioTransporte {
    TERRESTRE("Terrestre"),
    AVIAO("Avião"),
    HELICOPTERO("Helicóptero");

    private final String descricao;

}
