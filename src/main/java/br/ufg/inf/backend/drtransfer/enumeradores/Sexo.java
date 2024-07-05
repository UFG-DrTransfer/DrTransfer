package br.ufg.inf.backend.drtransfer.enumeradores;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Sexo {

    MASCULINO("Masculino"),
    FEMININO("Feminino"),
    NAO_INFORMADO("Não informado");

    private String descricao;

}
