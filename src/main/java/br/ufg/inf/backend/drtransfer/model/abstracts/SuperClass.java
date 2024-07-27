package br.ufg.inf.backend.drtransfer.model.abstracts;


import br.ufg.inf.backend.drtransfer.utils.SwaggerView;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public abstract class SuperClass implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(SwaggerView.Put.class)
    private Long id;

    @CreationTimestamp
    @JsonView(SwaggerView.NaoEditavel.class)
    private LocalDateTime dataCriacao;

    @UpdateTimestamp
    @JsonView(SwaggerView.NaoEditavel.class)
    private LocalDateTime dataAtualizacao;

    @JsonView(SwaggerView.Put.class)
    private Boolean ativo = true;

    @JsonIgnore
    public boolean isNovo() {
        return id == null || id == 0L;
    }
}
