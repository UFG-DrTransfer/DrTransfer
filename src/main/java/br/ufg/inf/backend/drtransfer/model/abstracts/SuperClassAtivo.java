package br.ufg.inf.backend.drtransfer.model.abstracts;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class SuperClassAtivo extends SuperClass {
    private Boolean ativo = true;
}
