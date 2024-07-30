package br.ufg.inf.backend.drtransfer.model;

import br.ufg.inf.backend.drtransfer.model.abstracts.SuperClass;
import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentoTransferencia extends SuperClass {

    @Schema(description = "Documento", example = "Documento do paciente")
    @Column(nullable = false)
    private String documento;

    @Schema(description = "Observação", example = "Paciente com pressão alta")
    @Column(length = 512)
    private String observacao;

    @OneToOne
    @JsonBackReference
    private Solicitacao solicitacao;
}
