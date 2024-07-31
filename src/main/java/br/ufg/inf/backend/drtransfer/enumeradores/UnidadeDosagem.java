package br.ufg.inf.backend.drtransfer.enumeradores;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UnidadeDosagem {
    CP("cp", "comprimido"),
    G("g", "gramas"),
    ML("ml", "militros");

    private final String sigla;
    private final String descricao;

}
