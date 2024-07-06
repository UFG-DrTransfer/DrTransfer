package br.ufg.inf.backend.drtransfer.model;

import jakarta.persistence.Entity;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class DocumentoTransferencia extends SuperClass{
    private List drogasAdministradas;
    private List procedimentosAcondicionamento;
    private List procedimentoRecebido;

}
