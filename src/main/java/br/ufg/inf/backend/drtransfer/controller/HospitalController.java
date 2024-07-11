package br.ufg.inf.backend.drtransfer.controller;


import br.ufg.inf.backend.drtransfer.exception.DrTransferException;
import br.ufg.inf.backend.drtransfer.model.Hospital;
import br.ufg.inf.backend.drtransfer.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/hospital")
public class HospitalController {

    @Autowired
    private HospitalService service;

    @GetMapping
    public ResponseEntity<?> getAll() {
      try{  List<Hospital> hospitals = service.findAll();
        if (hospitals.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(hospitals, HttpStatus.OK);
      } catch (Exception e){
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                  .body("Erro ao buscar hospital: " + e.getMessage());
      }
    }

    @GetMapping("/search")
    public ResponseEntity<?> findByName(@RequestParam String nome) {
        try {
            Hospital hospital = service.findByName(nome);
            return ResponseEntity.ok(hospital);
        }catch (DrTransferException e){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao buscar hospital: " + e.getMessage());

        }


    }



    @PostMapping
    public ResponseEntity<?> save(@RequestBody Hospital hospital) {
       try{
           Hospital savedHospital = service.save(hospital);
           return new ResponseEntity<>(savedHospital, HttpStatus.CREATED);
       }
       catch(DrTransferException e){
           return ResponseEntity
                   .status(HttpStatus.INTERNAL_SERVER_ERROR)
                   .body("Erro ao salvar hospital: " + e.getMessage());
       }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Hospital hospital) {
        try{
            Hospital savedHospital = service.update(hospital);
            return new ResponseEntity<>(savedHospital, HttpStatus.CREATED);
        }
        catch(DrTransferException e){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao atualizar hospital: " + e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<?> deleteHospital(@PathVariable Long id) {
        try{
            service.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(DrTransferException e){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao deletar hospital: " + e.getMessage());
        }
    }

}
