package br.ufg.inf.backend.drtransfer.model;

import br.ufg.inf.backend.drtransfer.enumeradores.MeioTransporte;
import br.ufg.inf.backend.drtransfer.model.abstracts.SuperClass;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transferencia extends SuperClass {
    private MeioTransporte meioTransporte;
    private Hospital hospitalDestino;
    private Medico medicoDestino;
    private Hospital hospitalOrigem;
    private Medico medicoOrigem;
    private MedicoRegulador medicoRegulador;
    private LocalDateTime horarioSaida;
    private LocalDateTime horarioPrevisotChegada;
    private Double distancia;
    private DocumentoTransferencia documento;
    private Paciente paciente;
    private Solicitacao solicitacao;

}
