package br.ufg.inf.backend.drtransfer.model;

import br.ufg.inf.backend.drtransfer.model.abstracts.SuperClass;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Cargo extends SuperClass {

    private String funcao;
    private String nome;


}
