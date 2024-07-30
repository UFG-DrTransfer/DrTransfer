package br.ufg.inf.backend.drtransfer.model;

import br.ufg.inf.backend.drtransfer.model.abstracts.SuperClass;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
public class Solicitacao extends SuperClass {

    private LocalDateTime horaSolicitacao;
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
