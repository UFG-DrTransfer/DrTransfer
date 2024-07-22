package br.ufg.inf.backend.drtransfer.model;

import br.ufg.inf.backend.drtransfer.model.abstracts.SuperClass;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Solicitacao extends SuperClass {
    private Medico medico;
    private Paciente paciente;
    private String motivo;
    private DocumentoTransferencia documento;
    private List<Especialidade> especialidadesRequisitada;
    private LocalDateTime horaSolicitacao;
}
