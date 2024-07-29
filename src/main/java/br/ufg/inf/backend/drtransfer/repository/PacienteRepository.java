package br.ufg.inf.backend.drtransfer.repository;

import br.ufg.inf.backend.drtransfer.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    /**
     * Verifica se existe o nome salvo no BD
     *
     * @param cpf
     * @return
     */
    boolean existsByCpf(String cpf);

    /**
     * Verifica se existe o nome que não tenha o id no BD
     *
     * @param cpf
     * @param id
     * @return
     */
    boolean existsByCpfAndIdNot(String cpf, Long id);
}

