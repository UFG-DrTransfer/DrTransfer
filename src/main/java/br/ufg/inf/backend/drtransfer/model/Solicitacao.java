package br.ufg.inf.backend.drtransfer.model;

import br.ufg.inf.backend.drtransfer.model.abstracts.SuperClass;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Solicitacao extends SuperClass {
    private LocalDateTime horaSolicitacao;
    private String motivo;

//    private Medico medico;
//    private Paciente paciente;
//
//    private DocumentoTransferencia documento;
//    private List<Especialidade> especialidadesRequisitada;
}
