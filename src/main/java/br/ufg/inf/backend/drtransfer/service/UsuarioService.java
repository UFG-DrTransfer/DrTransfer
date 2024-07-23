package br.ufg.inf.backend.drtransfer.service;

import br.ufg.inf.backend.drtransfer.model.Usuario;
import br.ufg.inf.backend.drtransfer.repository.UsuarioRespository;
import br.ufg.inf.backend.drtransfer.utils.GenericService;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService extends GenericService<Usuario, UsuarioRespository> {
    public UsuarioService() {
        super("Usuário");
    }

    @Override
    protected void atualizarEntidade(Usuario entidadePersistida, Usuario entidadeAtualizada) {
    }

    @Override
    protected void validaEntidade(Usuario entidade) {

    }

    @Override
    protected void atualizaVinculos(Usuario entidade) {

    }
}
