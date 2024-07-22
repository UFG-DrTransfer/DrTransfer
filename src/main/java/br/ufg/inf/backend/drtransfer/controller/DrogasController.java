package br.ufg.inf.backend.drtransfer.controller;

import br.ufg.inf.backend.drtransfer.exception.DrTransferException;
import br.ufg.inf.backend.drtransfer.model.Cargo;
import br.ufg.inf.backend.drtransfer.model.Drogas;
import br.ufg.inf.backend.drtransfer.model.Hospital;
import br.ufg.inf.backend.drtransfer.service.DrogasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drogas")
public class DrogasController {

    private final DrogasService service;

    public DrogasController(DrogasService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        try {
            List<Drogas> drogas = service.findAll();
            if (drogas.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return new ResponseEntity<>(drogas, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao buscar drogas: " + e.getMessage());
        }
    }


    @PostMapping
    public ResponseEntity<?> save(@RequestBody Drogas droga) {
        try {
            Drogas savedDroga = service.save(droga);
            return new ResponseEntity<>(savedDroga, HttpStatus.CREATED);
        } catch (DrTransferException e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao salvar droga: " + e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Drogas droga) {
        try {
            Drogas SavedDroga = service.update(droga);
            return new ResponseEntity<>(SavedDroga, HttpStatus.CREATED);
        } catch (DrTransferException e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao atualizar droga: " + e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<?> deleteDroga(@RequestBody Cargo cargo) {
        try {
            service.deleteById(cargo.getId());
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (DrTransferException e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao deletar droga: " + e.getMessage());
        }
    }


}
