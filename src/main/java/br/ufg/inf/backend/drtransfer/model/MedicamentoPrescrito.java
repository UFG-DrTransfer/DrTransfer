package br.ufg.inf.backend.drtransfer.model;

import br.ufg.inf.backend.drtransfer.enumeradores.UnidadeDosagem;
import br.ufg.inf.backend.drtransfer.model.abstracts.SuperClass;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MedicamentoPrescrito extends SuperClass {
    private String posologia;
    private Double dosagem;
    private String viaAdministracao;
    @Enumerated(EnumType.STRING)
    private UnidadeDosagem unidadeDosagem;

    private Drogas droga;
}
