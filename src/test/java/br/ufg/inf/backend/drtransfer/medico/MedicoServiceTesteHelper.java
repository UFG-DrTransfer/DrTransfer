package br.ufg.inf.backend.drtransfer.medico;

import br.ufg.inf.backend.drtransfer.exception.DrTransferException;
import br.ufg.inf.backend.drtransfer.model.Medico;
import br.ufg.inf.backend.drtransfer.service.MedicoService;

public class MedicoServiceTesteHelper extends MedicoService {
    public MedicoServiceTesteHelper() {
        super();
    }

    @Override
    public void padronizaCampos(Medico entidade) throws DrTransferException {
        super.padronizaCampos(entidade);
    }

    @Override
    public void validaEntidade(Medico entidade) throws DrTransferException {
        super.validaEntidade(entidade);
    }

    @Override
    public void atualizaVinculos(Medico entidade) throws DrTransferException {
        super.atualizaVinculos(entidade);
    }

    @Override
    public void atualizarEntidade(Medico entidadePersistida, Medico entidadeAtualizada) throws DrTransferException {
        super.atualizarEntidade(entidadePersistida, entidadeAtualizada);
    }
}
