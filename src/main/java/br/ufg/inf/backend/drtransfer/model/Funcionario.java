package br.ufg.inf.backend.drtransfer.model;

import br.ufg.inf.backend.drtransfer.model.abstracts.Pessoa;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data

public class Funcionario extends Pessoa{

    private String cargo;
    private Hospital hospitalDoFuncionario;

}
