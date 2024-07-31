package br.ufg.inf.backend.drtransfer.model;


import br.ufg.inf.backend.drtransfer.model.abstracts.SuperClass;
import br.ufg.inf.backend.drtransfer.model.abstracts.SuperClassAtivo;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Drogas extends SuperClassAtivo {

    @Column(nullable = false, unique = true)
    @Schema(description = "Nome", example = "Dipirona")
    private String nome;

    @Schema(description = "Principio ativo", example = "Dipirado")
    private String principioAtivo;

}
