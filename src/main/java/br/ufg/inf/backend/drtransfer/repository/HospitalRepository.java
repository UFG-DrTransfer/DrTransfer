package br.ufg.inf.backend.drtransfer.repository;

import br.ufg.inf.backend.drtransfer.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {
    Optional<Hospital> findByNome(String nome);

}
