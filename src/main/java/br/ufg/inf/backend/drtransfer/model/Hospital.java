package br.ufg.inf.backend.drtransfer.model;

import br.ufg.inf.backend.drtransfer.model.abstracts.SuperClassAtivo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Hospital extends SuperClassAtivo {

    @Schema(description = "Nome", example = "HGG")
    private String nome;

    @Schema(description = "Telefone", example = "62 0000-0000")
    private String telephoneNumber;

    @Schema(description = "Email", example = "hospital@hgg.com")
    private String email;

    @Schema(description = "Latitude", example = "-16.54512313")
    private Double latitude;

    @Schema(description = "Longitude", example = "-14.45461223")
    private Double longitude;

    @Schema(description = "Quantidade de leitos disponíveis", example = "10")
    private Integer availableBeds;

    @Schema(description = "Existe UTI no hospital", example = "true")
    private Boolean temUti = false;

  //  @JsonManagedReference
    @JsonIgnore
    @OneToMany (mappedBy = "hospital")
    private List<Funcionario> funcionarios;

}
