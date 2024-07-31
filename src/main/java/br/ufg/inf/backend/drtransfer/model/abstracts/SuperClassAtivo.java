package br.ufg.inf.backend.drtransfer.model.abstracts;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public abstract class SuperClassAtivo extends SuperClass {
    private Boolean ativo = true;
}
