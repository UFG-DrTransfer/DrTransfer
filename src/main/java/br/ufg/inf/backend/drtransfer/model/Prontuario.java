package br.ufg.inf.backend.drtransfer.model;

import br.ufg.inf.backend.drtransfer.enumeradores.Classificacao;
import br.ufg.inf.backend.drtransfer.model.abstracts.SuperClass;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class Prontuario extends SuperClass {
    @Enumerated(EnumType.STRING)
    private Classificacao classificacao;
    private List<MedicamentoPrescrito> medicamentoAtuais;
}
