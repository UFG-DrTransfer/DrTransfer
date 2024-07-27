package br.ufg.inf.backend.drtransfer.model;

import br.ufg.inf.backend.drtransfer.model.abstracts.SuperClass;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cargo extends SuperClass {

    @Schema(description = "Cargo", example = "Médico")
    @Column(unique = true, nullable = false)
    private String nome;
}
