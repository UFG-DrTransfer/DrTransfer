package br.ufg.inf.backend.drtransfer.model;

import br.ufg.inf.backend.drtransfer.enumeradores.MeioTransporte;
import br.ufg.inf.backend.drtransfer.model.abstracts.SuperClass;
import br.ufg.inf.backend.drtransfer.model.abstracts.SuperClassAtivo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder

public class Transferencia extends SuperClassAtivo {
    @Enumerated(EnumType.STRING)
    private MeioTransporte meioTransporte;

    private LocalDateTime horarioSaida;
    private LocalDateTime horarioPrevistoChegada;

    private Double distancia;
    @OneToOne
    private Solicitacao solicitacao;
    @ManyToOne
    private MedicoRegulador medicoRegulador;
    @ManyToOne
    private Medico medicoDestino;
    @ManyToOne
    private Hospital hospitalDestino;

    @OneToOne
    private Paciente paciente;
    @OneToOne
    private Medico medicoOrigem;
    @OneToOne
    private Hospital hospitalOrigem;
    @OneToOne
    private DocumentoTransferencia documento;

}
