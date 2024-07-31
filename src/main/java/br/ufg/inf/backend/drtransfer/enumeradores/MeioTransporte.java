package br.ufg.inf.backend.drtransfer.enumeradores;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MeioTransporte {
    TERRESTRE("Terrestre",null),
    AVIAO("Avião", 850.0),
    HELICOPTERO("Helicóptero",130.0);

    private final String descricao;
    private final Double kmHoraMedia;

    public Double getMetroPorSegundo(){
        return kmHoraMedia == null ? null : kmHoraMedia / 3.6 ;
    }
    public boolean isTerrestre(){
        return this == TERRESTRE;
    }
    public boolean isAviao(){
        return this == AVIAO;
    }
    public boolean isHelicoptero(){
        return this == HELICOPTERO;
    }

}
