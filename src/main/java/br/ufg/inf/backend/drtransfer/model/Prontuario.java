package br.ufg.inf.backend.drtransfer.model;

import br.ufg.inf.backend.drtransfer.enumeradores.Classificacao;
import br.ufg.inf.backend.drtransfer.model.abstracts.SuperClass;
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
    @OneToMany(mappedBy = "prontuario", cascade = CascadeType.ALL)
    private List<MedicamentoPrescrito> medicamentoPrescrito;
}
