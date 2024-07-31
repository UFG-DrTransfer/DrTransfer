package br.ufg.inf.backend.drtransfer.model.apirota;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Feature {
    private Properties properties;
}
