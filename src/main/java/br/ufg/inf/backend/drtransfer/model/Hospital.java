package br.ufg.inf.backend.drtransfer.model;

import br.ufg.inf.backend.drtransfer.model.abstracts.SuperClass;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Hospital extends SuperClass {

    private String name;
    private Endereco address;
    private String telephoneNumber;
    private String email;
    private Double latitute;
    private Double longitude;
    private Integer availableBeds;
    private boolean temUti;
    private Integer disponibilidadeLeitos;


}
