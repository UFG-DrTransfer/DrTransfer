package br.ufg.inf.backend.drtransfer.service;

import br.ufg.inf.backend.drtransfer.model.Cargo;
import br.ufg.inf.backend.drtransfer.repository.CargoRepository;

import java.util.List;

public class CargoService {

    private CargoRepository repository;

    public List<Cargo> findAll() {
        return repository.findAll();
    }
}
