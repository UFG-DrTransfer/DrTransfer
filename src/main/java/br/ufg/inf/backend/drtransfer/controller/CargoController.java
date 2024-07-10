package br.ufg.inf.backend.drtransfer.controller;

import br.ufg.inf.backend.drtransfer.model.Cargo;
import br.ufg.inf.backend.drtransfer.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Cargo")
public class CargoController
{
    @Autowired
    private CargoService service;

    @GetMapping
    public ResponseEntity<String> findAll(){
        try {
            List<Cargo> cargos = service.findAll();
            if (cargos.isEmpty())
            {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(cargos.toString());
        }catch (Exception e ){
            return  ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao buscar cargo" + e.getMessage());

        }
    }


}
