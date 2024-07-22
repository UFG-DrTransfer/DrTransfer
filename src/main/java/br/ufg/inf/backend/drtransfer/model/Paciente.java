package br.ufg.inf.backend.drtransfer.model;

import br.ufg.inf.backend.drtransfer.enumeradores.TipoSanguineo;
import br.ufg.inf.backend.drtransfer.model.abstracts.Pessoa;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Paciente extends Pessoa {
    private String dataNascimento;
    @Enumerated(EnumType.STRING)
    private TipoSanguineo tipoSanguineo;
    private Prontuario prontuario;
}
