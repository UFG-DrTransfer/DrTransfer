package br.ufg.inf.backend.drtransfer.model;

import br.ufg.inf.backend.drtransfer.enumeradores.UnidadeDosagem;
import br.ufg.inf.backend.drtransfer.model.abstracts.SuperClass;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicamentoPrescrito extends SuperClass {
    private Drogas droga;
    private String posologia;
    private Double dosagem;
    private UnidadeDosagem unidadeDosagem;
    private String viaAdministracao;
}
