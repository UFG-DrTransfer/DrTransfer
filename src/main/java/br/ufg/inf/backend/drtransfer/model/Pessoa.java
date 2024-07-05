package br.ufg.inf.backend.drtransfer.model;

import br.ufg.inf.backend.drtransfer.enumeradores.Sexo;
import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
@Data
public abstract class Pessoa extends SuperClass {
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private Sexo sexo;
}
