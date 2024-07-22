package br.ufg.inf.backend.drtransfer.controller;

import br.ufg.inf.backend.drtransfer.exception.DrTransferException;
import br.ufg.inf.backend.drtransfer.model.Cargo;
import br.ufg.inf.backend.drtransfer.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestController
@RequestMapping("/Cargo")
public class CargoController
{
    private final CargoService service;

    public CargoController(CargoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        try {
            List<Cargo> cargos = service.findAll();
            if (cargos.isEmpty())
            {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(cargos.toString());
        }catch (Exception e ){
            return  ResponseEntity
                    .status(INTERNAL_SERVER_ERROR)
                    .body("Erro ao buscar cargo" + e.getMessage());

        }
    }

    @GetMapping("/search")
    public ResponseEntity<?> findByName(@RequestParam String name){
        try{
            Cargo cargo = service.findByName(name);
            return ResponseEntity.ok(cargo);

        }catch (DrTransferException e)
        {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }


    @PostMapping
    public ResponseEntity<?> save(@RequestBody Cargo cargo)
    {
       try {
           Cargo createdCargo = service.save(cargo);
           return ResponseEntity
                   .status(HttpStatus.CREATED)
                   .body(createdCargo); //200 ok!}
       } catch (Exception e){
           return ResponseEntity
                   .status(INTERNAL_SERVER_ERROR)
                   .body("Erro ao salvar cargo" + e.getMessage());
    }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Cargo cargo)
    {
        try {
            Cargo updatedCargo = service.update(cargo);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(updatedCargo);
        }catch (Exception e)
        {
            return ResponseEntity
                    .status(INTERNAL_SERVER_ERROR)
                    .body("Erro ao atualizar cargo" + e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody Long id)
    {
        try{
            service.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);

        }catch (Exception e)
        {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao deletar cargo" + e.getMessage());
        }
    }

    @DeleteMapping("/deleteByName")
    public ResponseEntity<?> deleteByName (@RequestParam String name) {
        try {
            service.deleteByName(name);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (DrTransferException e)
        {
            return ResponseEntity
                    .status(INTERNAL_SERVER_ERROR)
                    .body("Erro ao deletar cargo: " + e.getMessage());
        }

    }






}
