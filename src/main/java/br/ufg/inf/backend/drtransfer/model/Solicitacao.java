package br.ufg.inf.backend.drtransfer.model;

import br.ufg.inf.backend.drtransfer.model.abstracts.SuperClassAtivo;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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

public class Solicitacao extends SuperClassAtivo {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime horaSolicitacao = LocalDateTime.now();
    private String motivo;

    @ManyToOne
    private Medico medico;
    @ManyToOne
    private Paciente paciente;

    @OneToOne(mappedBy = "solicitacao", cascade = CascadeType.ALL)
    @JsonManagedReference
    private DocumentoTransferencia documento;
    @ManyToOne
    private Especialidade especialidade;
}
