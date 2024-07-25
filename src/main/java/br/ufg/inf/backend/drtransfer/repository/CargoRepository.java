package br.ufg.inf.backend.drtransfer.repository;

import br.ufg.inf.backend.drtransfer.model.Cargo;
import br.ufg.inf.backend.drtransfer.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {

    /**
     * Verifica se existe o nome salvo no BD
     * @param nome
     * @return
     */
    boolean existsByNome(String nome);

    /**
     * Verifica se existe o nome que não tenha o id no BD
     * @param nome
     * @param id
     * @return
     */
    boolean existsByNomeAndIdNot(String nome, Long id);

}