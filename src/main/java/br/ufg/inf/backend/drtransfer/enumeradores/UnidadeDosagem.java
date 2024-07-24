package br.ufg.inf.backend.drtransfer.enumeradores;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UnidadeDosagem {
    ML("ml", "militros"),
    G("g", "gramas"),
    CP("cp", "comprimido");

    private final String sigla;
    private final String descricao;

}
