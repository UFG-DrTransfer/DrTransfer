package br.ufg.inf.backend.drtransfer.utils;

import br.ufg.inf.backend.drtransfer.exception.DrTransferException;
import br.ufg.inf.backend.drtransfer.model.E;
import br.ufg.inf.backend.drtransfer.model.abstracts.SuperClass;
import br.ufg.inf.backend.drtransfer.service.EService;
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

    @GetMapping("/search")
    public ResponseEntity<?> findByName(@RequestParam String nome) {
        try {
            E entidade = service.findByName(nome);
            return ResponseEntity.ok(entidade);
        } catch (DrTransferException e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao buscar entidade: " + e.getMessage());
        }
    }


    @PostMapping
    public ResponseEntity<?> save(@RequestBody E entidade) {
        try {
            E savedE = service.save(entidade);
            return new ResponseEntity<>(savedE, HttpStatus.CREATED);
        } catch (DrTransferException e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao salvar entidade: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody E entidade) {
        try {
            E entidadePersistida = service.findById(id);
            if(entidadePersistida != null) {
                atualizarEntidade(entidadePersistida, entidade);
                return new ResponseEntity<>(service.update(entidadePersistida), HttpStatus.CREATED);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (DrTransferException e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao atualizar entidade: " + e.getMessage());
        }
    }

    /**
     * Essa função vai definir os set nos atributos que serão atualizados dessa entidade.
     * @param entidadePersistida  entidade que foi recuperada do banco
     * @param entidadeAtualizada  entidade que contem os novos dados a serem SETADOS
     */
    protected abstract void atualizarEntidade(T entidadePersistida, T entidadeAtualizada);
}

//    @PutMapping("/{id}")
//    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody T entidadeAtualizada) {
//        T entidade = service.findById(id);
//        if (entidade != null) {
//            atualizarEntidade(entidade, entidadeAtualizada);
//            return ResponseEntity.ok(service.save(entidade));
//        }
//        return ResponseEntity.notFound().build();
//    }
//




    @DeleteMapping
    public ResponseEntity<?> deleteE(@PathVariable Long id) {
        try {
            service.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (DrTransferException e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao deletar entidade: " + e.getMessage());
        }
    }

}
