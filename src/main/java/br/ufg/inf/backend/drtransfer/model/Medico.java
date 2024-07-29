package br.ufg.inf.backend.drtransfer.model;


import br.ufg.inf.backend.drtransfer.utils.SwaggerView;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
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
public class Medico extends Funcionario {

    @Schema(description = "CRM", example = "15616GO")
    private String crm;

    @ManyToOne
    @JsonManagedReference
    @Schema(description = "Especialidade", example = "{ \"id\": 1}")
    private Especialidade especialidade;
}
