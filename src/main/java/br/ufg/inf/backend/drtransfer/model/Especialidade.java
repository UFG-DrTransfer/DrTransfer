package br.ufg.inf.backend.drtransfer.model;

import br.ufg.inf.backend.drtransfer.model.abstracts.SuperClass;
import br.ufg.inf.backend.drtransfer.model.abstracts.SuperClassAtivo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder

public class Especialidade extends SuperClassAtivo {
    @Schema(description = "Nome", example = "Cardiologia")
    private String nome;

    @Schema(description = "Descrição", example = "faz cirugia do coração")
    private String descricao;

}
