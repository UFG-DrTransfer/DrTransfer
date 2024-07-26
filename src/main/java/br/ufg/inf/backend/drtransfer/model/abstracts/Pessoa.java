package br.ufg.inf.backend.drtransfer.model.abstracts;

import br.ufg.inf.backend.drtransfer.enumeradores.Sexo;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public abstract class Pessoa extends SuperClass {
    @Column(nullable = false)
    private String nome;

    @Column(unique = true)
    private String cpf;

    private String telefone;

    private String email;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;
}
