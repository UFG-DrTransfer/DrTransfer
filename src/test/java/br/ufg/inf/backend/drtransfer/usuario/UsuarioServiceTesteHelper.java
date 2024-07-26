package br.ufg.inf.backend.drtransfer.usuario;

import br.ufg.inf.backend.drtransfer.exception.DrTransferException;
import br.ufg.inf.backend.drtransfer.model.Usuario;
import br.ufg.inf.backend.drtransfer.service.UsuarioService;

public class UsuarioServiceTesteHelper extends UsuarioService {
    public UsuarioServiceTesteHelper() {
        super();
    }

    @Override
    public void padronizaCampos(Usuario entidade) {
        super.padronizaCampos(entidade);
    }

    @Override
    public void validaEntidade(Usuario entidade) throws DrTransferException {
        super.validaEntidade(entidade);
    }

    @Override
    public void atualizarEntidade(Usuario entidadePersistida, Usuario entidadeAtualizada) throws DrTransferException {
        super.atualizarEntidade(entidadePersistida, entidadeAtualizada);
    }
}
