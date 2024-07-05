package br.ufg.inf.backend.drtransfer.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Endereco extends SuperClass {
    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;

}
