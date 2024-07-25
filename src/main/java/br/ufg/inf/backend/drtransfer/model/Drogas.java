package br.ufg.inf.backend.drtransfer.model;


import br.ufg.inf.backend.drtransfer.model.abstracts.SuperClass;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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

public class Drogas extends SuperClass {

    @Column(nullable = false, unique = true)
    private String nome;
    private String principioAtivo;

}
