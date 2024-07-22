package br.ufg.inf.backend.drtransfer.model;


import br.ufg.inf.backend.drtransfer.model.abstracts.SuperClass;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Drogas extends SuperClass {

    private Long id;
    private String nome;
    private String principioAtivo;
    private String descricao;
}
