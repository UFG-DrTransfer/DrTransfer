package br.ufg.inf.backend.drtransfer.model;

import br.ufg.inf.backend.drtransfer.enumeradores.UnidadeDosagem;
import br.ufg.inf.backend.drtransfer.model.abstracts.SuperClass;
import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicamentoPrescrito extends SuperClass {
    @Schema(description = "Forma de administração", example = "1/24 horas")
    @Column(nullable = false)
    private String posologia;
    @Schema(description = "Dosagem", example = "5.0")
    @Column(nullable = false)
    private Double dosagem;
    @Schema(description = "Via administração", example = "Oral")
    @Column(nullable = false)
    private String viaAdministracao;
    @Schema(description = "Unidade Dosagem", example = "ml")
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UnidadeDosagem unidadeDosagem;
    @Schema(description = "Medicamento")
    @ManyToOne
    private Drogas droga;

    @JsonBackReference
    @ManyToOne(optional = false)
    private Prontuario prontuario;



}
