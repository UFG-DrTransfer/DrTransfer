package br.ufg.inf.backend.drtransfer.model;

import br.ufg.inf.backend.drtransfer.enumeradores.Sexo;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Medico extends Funcionario {

    @Schema(description = "CRM", example = "15616GO")
    private String crm;

    @ManyToOne
    @Schema(description = "Especialidade", example = "{ \"id\": 1}")
    private Especialidade especialidade;

    public Medico(String nome, String cpf, String telefone, String email, Sexo sexo, Cargo cargo, Hospital hospital, String crm, Especialidade especialidade) {
        super(nome, cpf, telefone, email, sexo, cargo, hospital);
        this.crm = crm;
        this.especialidade = especialidade;
    }
}
