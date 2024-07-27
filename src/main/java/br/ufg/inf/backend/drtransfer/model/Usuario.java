package br.ufg.inf.backend.drtransfer.model;

import br.ufg.inf.backend.drtransfer.model.abstracts.SuperClass;
import br.ufg.inf.backend.drtransfer.utils.SwaggerView;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Usuario extends SuperClass {

    @Column(unique = true, nullable = false)
    @Schema(description = "Login do usuário", example = "admin")
    private String login;

    @Schema(accessMode = Schema.AccessMode.WRITE_ONLY, description = "Senha do usuário", example = "Abc123")
    private String senha;

}
