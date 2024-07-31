package br.ufg.inf.backend.drtransfer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"br.ufg.inf.backend.drtransfer", "br.ufg.inf.backend.openroute.controller"})
public class DrtransferApplication {

    public static void main(String[] args) {
        SpringApplication.run(DrtransferApplication.class, args);
    }
}
