package br.ufg.inf.backend.drtransfer.model;

import br.ufg.inf.backend.drtransfer.enumeradores.UnidadeDosagem;
import br.ufg.inf.backend.drtransfer.model.abstracts.SuperClass;
import br.ufg.inf.backend.drtransfer.utils.SwaggerView;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;
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

    @Column(nullable = false)
    @Schema(description = "Forma de administração", example = "1/24 horas")
    private String posologia;

    @Column(nullable = false)
    @Schema(description = "Dosagem", example = "5.0")
    private Double dosagem;

    @Column(nullable = false)
    @Schema(description = "Via administração", example = "Oral")
    private String viaAdministracao;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @Schema(description = "Unidade Dosagem", example = "ML")
    private UnidadeDosagem unidadeDosagem;

    @ManyToOne
    @Schema(description = "Medicamento")
    private Drogas droga;

    @JsonBackReference
    @ManyToOne(optional = false)
    @JsonView(SwaggerView.NaoEditavel.class)
    private Prontuario prontuario;


}
