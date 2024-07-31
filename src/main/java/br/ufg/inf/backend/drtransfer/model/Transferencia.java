package br.ufg.inf.backend.drtransfer.model;

import br.ufg.inf.backend.drtransfer.enumeradores.MeioTransporte;
import br.ufg.inf.backend.drtransfer.model.abstracts.SuperClassAtivo;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
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
