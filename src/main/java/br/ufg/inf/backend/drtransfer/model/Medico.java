package br.ufg.inf.backend.drtransfer.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medico extends Funcionario {

    @Schema(description = "CRM", example = "15616GO")
    private String crm;

    @ManyToOne
    @Schema(description = "Especialidade", example = "{ \"id\": 1}")
    private Especialidade especialidade;
}
