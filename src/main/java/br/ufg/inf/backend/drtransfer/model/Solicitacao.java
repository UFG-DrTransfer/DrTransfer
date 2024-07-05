package br.ufg.inf.backend.drtransfer.model;

import jakarta.persistence.Entity;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Solicitacao extends SuperClass{
    private Medico medico;
    private Paciente paciente;
    private String motivo;
    private DocumentoTransferencia documento;
    private List<Especialidade> especialidadesRequisitada;
    private LocalDateTime horaSolicitacao;
}
