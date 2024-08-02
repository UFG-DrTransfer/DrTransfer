package br.ufg.inf.backend.drtransfer.utils;

import br.ufg.inf.backend.drtransfer.exception.DrTransferException;
import br.ufg.inf.backend.drtransfer.model.abstracts.SuperClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

public abstract class GenericControllerWithDeletion<E extends SuperClass, S extends GenericService<E, ? extends JpaRepository<E, Long>>> extends GenericController<E,S>{


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteE(@PathVariable Long id) {
        try {
            service.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (DrTransferException e) {
            return ResponseEntity.status(e.getStatus()).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Falha ao deletar: " + e.getMessage());
        }
    }

}
