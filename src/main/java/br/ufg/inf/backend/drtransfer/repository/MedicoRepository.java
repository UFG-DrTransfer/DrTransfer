package br.ufg.inf.backend.drtransfer.repository;

import br.ufg.inf.backend.drtransfer.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {

    boolean existsByCpf(String cpf);

    boolean existsByCpfAndIdNot(String cpf, Long id);

    boolean existsByCrmAndIdNot(String crm, Long id);

    boolean existsByCrm(String crm);
}

