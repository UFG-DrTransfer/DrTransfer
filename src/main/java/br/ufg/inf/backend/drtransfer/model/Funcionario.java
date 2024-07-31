package br.ufg.inf.backend.drtransfer.model;

import br.ufg.inf.backend.drtransfer.enumeradores.Sexo;
import br.ufg.inf.backend.drtransfer.model.abstracts.Pessoa;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Funcionario extends Pessoa {
    @ManyToOne
    private Cargo cargo;

    @ManyToOne
    @JsonBackReference
    private Hospital hospital;

    public Funcionario(String nome, String cpf, String telefone, String email, Sexo sexo, Cargo cargo, Hospital hospital) {
        super(nome, cpf, telefone, email, sexo);
        this.cargo = cargo;
        this.hospital = hospital;
    }
}
