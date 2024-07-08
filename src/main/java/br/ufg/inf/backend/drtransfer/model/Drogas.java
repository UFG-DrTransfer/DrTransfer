package br.ufg.inf.backend.drtransfer.model;


import br.ufg.inf.backend.drtransfer.model.abstracts.SuperClass;
import br.ufg.inf.backend.drtransfer.model.abstracts.SuperClass;
import jakarta.persistence.Entity;
import lombok.Data;


@Entity
@Data
public class Drogas extends SuperClass {

    private Long id;
    private String nome;
    private String principioAtivo;
    private String descricao;
}
