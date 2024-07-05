package br.ufg.inf.backend.drtransfer.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class MedicoRegulador extends Pessoa{
    private String crm;
}
