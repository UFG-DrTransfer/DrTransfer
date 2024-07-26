package br.ufg.inf.backend.drtransfer.model;

import br.ufg.inf.backend.drtransfer.enumeradores.Classificacao;
import br.ufg.inf.backend.drtransfer.model.abstracts.SuperClass;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
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
public class Prontuario extends SuperClass {
    @Enumerated(EnumType.STRING)
    private Classificacao classificacao;
    @JsonManagedReference
    @OneToMany(mappedBy = "prontuario", cascade = CascadeType.ALL)
    private List<MedicamentoPrescrito> medicamentoPrescrito;

    @JsonBackReference
    @OneToOne
    private Paciente paciente;
}
