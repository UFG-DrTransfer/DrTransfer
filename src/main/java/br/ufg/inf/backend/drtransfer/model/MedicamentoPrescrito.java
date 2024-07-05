package br.ufg.inf.backend.drtransfer.model;

import br.ufg.inf.backend.drtransfer.enumeradores.UnidadeDosagem;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class MedicamentoPrescrito extends SuperClass {
    private Drogas droga;
    private String posologia;
    private Double dosagem;
    private UnidadeDosagem unidadeDosagem;
    private String viaAdministracao;
}
