package br.ufg.inf.backend.drtransfer.model;

import br.ufg.inf.backend.drtransfer.enumeradores.TipoSanguineo;
import br.ufg.inf.backend.drtransfer.model.abstracts.Pessoa;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Paciente extends Pessoa {
    private String dataNascimento;
    private TipoSanguineo tipoSanguineo;
    private Prontuario prontuario;
}
