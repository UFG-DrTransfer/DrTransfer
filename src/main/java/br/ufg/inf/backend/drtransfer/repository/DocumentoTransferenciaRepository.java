package br.ufg.inf.backend.drtransfer.repository;

import br.ufg.inf.backend.drtransfer.model.DocumentoTransferencia;
import br.ufg.inf.backend.drtransfer.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentoTransferenciaRepository extends JpaRepository<DocumentoTransferencia, Long> {
}
