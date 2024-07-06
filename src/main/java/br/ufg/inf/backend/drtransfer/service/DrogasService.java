package br.ufg.inf.backend.drtransfer.service;

import br.ufg.inf.backend.drtransfer.repository.DocumentoTransferenciaRepository;
import br.ufg.inf.backend.drtransfer.repository.DrogasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DrogasService {

        @Autowired
        private DrogasRepository repository;
}
