package br.ufg.inf.backend.drtransfer.model;

import br.ufg.inf.backend.drtransfer.enumeradores.UnidadeDosagem;
import br.ufg.inf.backend.drtransfer.model.abstracts.SuperClass;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class MedicamentoPrescrito extends SuperClass {
    @Column(nullable = false)
    private String posologia;
    @Column(nullable = false)
    private Double dosagem;
    @Column(nullable = false)
    private String viaAdministracao;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UnidadeDosagem unidadeDosagem;
    @ManyToOne
    private Drogas droga;

    @JsonBackReference
    @ManyToOne(optional = false)
    private Prontuario prontuario;



}
