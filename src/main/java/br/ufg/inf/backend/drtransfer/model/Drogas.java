package br.ufg.inf.backend.drtransfer.model;

<<<<<<< HEAD
public class Drogas extends SuperClass{
=======
import br.ufg.inf.backend.drtransfer.model.abstracts.SuperClass;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Drogas extends SuperClass {
    private Long id;
    private String nome;
    private String principioAtivo;
    private String descricao;
>>>>>>> 1eb7bd08f5e25dbb0e7e1718293f0fbeac4cb3c8
}
