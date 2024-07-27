package br.ufg.inf.backend.drtransfer.model;

import br.ufg.inf.backend.drtransfer.model.abstracts.Pessoa;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class Funcionario extends Pessoa {
    @Schema(description = "Cargo", example = "{ \"id\": 1}")
    @ManyToOne
    private Cargo cargo;
    @Schema(description = "Hospital", example = "{ \"id\": 1}")
    @JsonBackReference
    @ManyToOne
    private Hospital hospital;
}
