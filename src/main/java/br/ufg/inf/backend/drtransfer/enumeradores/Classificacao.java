package br.ufg.inf.backend.drtransfer.enumeradores;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Classificacao {
    PRIMARIA("Primária"),
    SECUNDARIA("Secundária"),
    TERCIARIA("Terciária");
    private final String descricao;
}
