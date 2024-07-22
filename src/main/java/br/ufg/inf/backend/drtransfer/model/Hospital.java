package br.ufg.inf.backend.drtransfer.model;

import br.ufg.inf.backend.drtransfer.model.abstracts.SuperClass;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hospital extends SuperClass {


    private String name;
    private String telephoneNumber;
    private String email;
    private Double latitute;
    private Double longitude;
    private Integer availableBeds;
    private boolean temUti;
    private Integer disponibilidadeLeitos;

    @OneToOne
    private Endereco endereco;
    @OneToMany(mappedBy = "hospital")
    private List<Medico> medicos;
}
