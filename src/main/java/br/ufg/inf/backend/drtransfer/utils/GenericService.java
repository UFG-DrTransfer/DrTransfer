package br.ufg.inf.backend.drtransfer.utils;

import br.ufg.inf.backend.drtransfer.exception.DrTransferException;
import br.ufg.inf.backend.drtransfer.model.abstracts.SuperClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class GenericService<E extends SuperClass, R extends JpaRepository<E, Long>> {

    @Autowired
    protected R repository;
    private String nomeClasse;

    //Dar nome as classes para o retorno das mensagens.
    public GenericService(String nomeClasse) {
        this.nomeClasse = nomeClasse;
    }

    public List<E> findAll() {
        return repository.findAll();
    }

    public E findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public E save(E entidade) {
        try {
            return repository.save(entidade);
        } catch (Exception e) {
            throw new DrTransferException("Falha ao salvar %s", nomeClasse);
        }
    }

    public E update(E entidade) {
        Optional<E> existingE = repository.findById(entidade.getId());
        if (existingE.isPresent()) {
            return repository.save(entidade);
        } else {
            throw new DrTransferException("%s com ID %d não encontrado", nomeClasse, entidade.getId());
        }
    }

    public void deleteById(Long id) {
        Optional<E> existingE = repository.findById(id);
        if (existingE.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new DrTransferException("%s com ID %d não encontrado", nomeClasse, id);
        }
    }

}

