package br.ufg.inf.backend.drtransfer.repository;

import br.ufg.inf.backend.drtransfer.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRespository extends JpaRepository<Usuario, Long> {
    Usuario findByLogin(String login);

    /**
     * Verifica se existe o login salvo no BD
     *
     * @param login
     * @return
     */
    boolean existsByLogin(String login);

    /**
     * Verifica se existe o login que não tenha o id no BD
     *
     * @param login
     * @param id
     * @return
     */
    boolean existsByLoginAndIdNot(String login, Long id);
}
