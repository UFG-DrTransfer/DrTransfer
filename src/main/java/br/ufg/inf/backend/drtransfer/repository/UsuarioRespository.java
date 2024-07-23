package br.ufg.inf.backend.drtransfer.repository;

import br.ufg.inf.backend.drtransfer.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRespository extends JpaRepository<Usuario, Long> {
}
