package br.ufg.inf.backend.drtransfer.model;

import br.ufg.inf.backend.drtransfer.model.abstracts.Pessoa;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Medico extends Pessoa {
    private String crm;
    private Hospital hospital;
    private Especialidade especialidade;
}
