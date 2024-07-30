package br.ufg.inf.backend.openroute;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenRouteServiceConfig {

    @Value("${openrouteservice.api.key}")
    private String apiKey;

    public String getApiKey() {
        return apiKey;
    }
}