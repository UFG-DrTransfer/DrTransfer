package br.ufg.inf.backend.drtransfer.enumeradores;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UnidadeDosagem {
    ML("ml"),
    G("g"),
    CP("cp");

    private String descricao;

}
