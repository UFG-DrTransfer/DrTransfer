package br.ufg.inf.backend.drtransfer.model;

import br.ufg.inf.backend.drtransfer.enumeradores.MeioTransporte;
import br.ufg.inf.backend.drtransfer.model.abstracts.SuperClass;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transferencia extends SuperClass {
    @Enumerated(EnumType.STRING)
    private MeioTransporte meioTransporte;

    private LocalDateTime horarioSaida;
    private LocalDateTime horarioPrevisotChegada;

    private Double distancia;

    private Paciente paciente;
    private Medico medicoOrigem;
    private Hospital hospitalOrigem;
    private Medico medicoDestino;
    private Hospital hospitalDestino;

    private MedicoRegulador medicoRegulador;

    private DocumentoTransferencia documento;
    private Solicitacao solicitacao;

}
