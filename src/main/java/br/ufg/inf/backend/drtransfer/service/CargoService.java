package br.ufg.inf.backend.drtransfer.service;

import br.ufg.inf.backend.drtransfer.exception.DrTransferException;
import br.ufg.inf.backend.drtransfer.model.Cargo;
import br.ufg.inf.backend.drtransfer.repository.CargoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CargoService {

    private CargoRepository repository;

    public List<Cargo> findAll() {
        return repository.findAll();
    }

    public Cargo findByName(String nome) {
        Optional<Cargo> cargo = repository.findByName(nome);
        if (cargo.isPresent()) {
            return cargo.get();
        }else{
            throw new DrTransferException("Cargo com nome: "  + nome + " nao encontrado");
        }
    }

    public Cargo save (Cargo cargo) {
        try {
            return repository.save(cargo);
        }catch (Exception e){
            throw new DrTransferException("Erro ao salvar cargo");
        }
    }

    public Cargo update (Cargo cargo) {
        Optional<Cargo> cargoOptional = repository.findById(cargo.getId());
        if (cargoOptional.isPresent()) {
            return save(cargo);
        }else{
            throw new DrTransferException("Cargo com ID %D nao encontrado", cargo.getId());
        }
    }

    public void deleteById (Long id) {
        Optional<Cargo> cargoOptional = repository.findById(id);
        if (cargoOptional.isPresent()) {
            repository.deleteById(id);
        }else{
            throw new DrTransferException("Cargo com ID %D nao encontrado", id);
        }
    }

    public void deleteByName(String nome) {
        Optional<Cargo> cargoOptional = repository.findByName(nome);
        if (cargoOptional.isPresent()) {
            repository.deleteByName(nome);
        }else {
            throw new DrTransferException("Cargo com nome: "  + nome + " nao encontrado");
        }
    }
}
