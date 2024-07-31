package br.ufg.inf.backend.drtransfer.especialidade;

import br.ufg.inf.backend.drtransfer.exception.DrTransferException;
import br.ufg.inf.backend.drtransfer.model.Especialidade;
import br.ufg.inf.backend.drtransfer.service.EspecialidadeService;

public class EspecialidadeServiceTesteHelper extends EspecialidadeService {
    public EspecialidadeServiceTesteHelper() {
        super();
    }

    @Override
    public void padronizaCampos(Especialidade entidade) throws DrTransferException {
        super.padronizaCampos(entidade);
    }

    @Override
    public void validaEntidade(Especialidade entidade) throws DrTransferException {
        super.validaEntidade(entidade);
    }

    @Override
    public void atualizaVinculos(Especialidade entidade) throws DrTransferException {
        super.atualizaVinculos(entidade);
    }

    @Override
    public void atualizarEntidade(Especialidade entidadePersistida, Especialidade entidadeAtualizada) throws DrTransferException {
        super.atualizarEntidade(entidadePersistida, entidadeAtualizada);
    }
}

