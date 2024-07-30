package br.ufg.inf.backend.drtransfer.model;

import br.ufg.inf.backend.drtransfer.enumeradores.Classificacao;
import br.ufg.inf.backend.drtransfer.model.abstracts.SuperClass;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prontuario extends SuperClass {

    @Enumerated(EnumType.STRING)
    @Schema(description = "Classificação", example = "TERCIARIA")
    private Classificacao classificacao;

    @JsonManagedReference
    @OneToMany(mappedBy = "prontuario", cascade = CascadeType.ALL)
    @Schema(description = "Medicamento Prescrito")
    private List<MedicamentoPrescrito> medicamentoPrescrito;

    @OneToOne
    @JsonBackReference
    private Paciente paciente;
}
