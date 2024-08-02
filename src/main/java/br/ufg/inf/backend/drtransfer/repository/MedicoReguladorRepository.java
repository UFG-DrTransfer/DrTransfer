package br.ufg.inf.backend.drtransfer.repository;

import br.ufg.inf.backend.drtransfer.model.MedicoRegulador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  MedicoReguladorRepository extends JpaRepository<MedicoRegulador, Long> {


    boolean existsByCrm(String crm);

    boolean existsByCrmAndIdNot(String cpf, Long id);
}
