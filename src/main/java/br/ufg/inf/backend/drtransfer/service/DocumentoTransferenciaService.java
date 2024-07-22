package br.ufg.inf.backend.drtransfer.service;

import br.ufg.inf.backend.drtransfer.repository.DocumentoTransferenciaRepository;
import br.ufg.inf.backend.drtransfer.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentoTransferenciaService {

    @Autowired
    private DocumentoTransferenciaRepository repository;
}

