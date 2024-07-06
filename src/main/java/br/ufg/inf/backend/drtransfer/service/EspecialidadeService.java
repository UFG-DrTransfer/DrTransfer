package br.ufg.inf.backend.drtransfer.service;

import br.ufg.inf.backend.drtransfer.repository.EspecialidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EspecialidadeService {
    @Autowired
    private EspecialidadeRepository repository;
}
