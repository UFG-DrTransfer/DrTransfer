package br.ufg.inf.backend.drtransfer.model.abstracts;

import br.ufg.inf.backend.drtransfer.enumeradores.Sexo;
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
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
}
