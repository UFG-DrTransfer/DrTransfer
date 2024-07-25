package br.ufg.inf.backend.drtransfer.model;


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
public class Medico extends Funcionario {

    private String crm;
    @ManyToOne
    private Hospital hospital;
    @ManyToOne
    private Especialidade especialidade;
}
