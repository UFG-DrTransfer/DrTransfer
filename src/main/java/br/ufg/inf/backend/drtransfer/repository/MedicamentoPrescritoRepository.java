package br.ufg.inf.backend.drtransfer.repository;

import br.ufg.inf.backend.drtransfer.model.MedicamentoPrescrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicamentoPrescritoRepository extends JpaRepository<MedicamentoPrescrito, Long> {
}
