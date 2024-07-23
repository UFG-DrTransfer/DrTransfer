package br.ufg.inf.backend.drtransfer.utils;

import br.ufg.inf.backend.drtransfer.exception.DrTransferException;
import br.ufg.inf.backend.drtransfer.exception.DrTransferNotFoundException;
import br.ufg.inf.backend.drtransfer.model.abstracts.SuperClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Generic Controller < Entidade estende SuperClass, Service extende de GenericService
public abstract class GenericController<E extends SuperClass, S extends GenericService> {

    @Autowired
    protected S service;

    @GetMapping
    public ResponseEntity<?> getAll() {
        try {
            List<E> entidades = service.findAll();
            if (entidades.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(entidades, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao buscar entidade: " + e.getMessage());
        }
    }

//    @GetMapping("/search")
//    public ResponseEntity<?> findByName(@RequestParam String nome) {
//        try {
//            E entidade = service.findByName(nome);
//            return ResponseEntity.ok(entidade);
//        } catch (DrTransferException e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Erro ao buscar entidade: " + e.getMessage());
//        }
//    }


    @PostMapping
    public ResponseEntity<?> save(@RequestBody E entidade) {
        try {
            return new ResponseEntity<>(service.save(entidade), HttpStatus.CREATED);
        } catch (DrTransferException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao salvar entidade: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody E entidade) {
        try {
            return new ResponseEntity<>(service.update(id, entidade), HttpStatus.CREATED);
        } catch (DrTransferNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (DrTransferException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao atualizar entidade: " + e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<?> deleteE(@PathVariable Long id) {
        try {
            service.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (DrTransferException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao deletar entidade: " + e.getMessage());
        }
    }

}
