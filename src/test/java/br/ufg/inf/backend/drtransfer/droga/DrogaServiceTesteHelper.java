package br.ufg.inf.backend.drtransfer.droga;

import br.ufg.inf.backend.drtransfer.exception.DrTransferException;
import br.ufg.inf.backend.drtransfer.model.Drogas;
import br.ufg.inf.backend.drtransfer.service.DrogasService;

public class DrogaServiceTesteHelper extends DrogasService {
    public DrogaServiceTesteHelper() {
        super();
    }

    @Override
    public void padronizaCampos(Drogas entidade) throws DrTransferException {
        super.padronizaCampos(entidade);
    }

    @Override
    public void validaEntidade(Drogas entidade) throws DrTransferException {
        super.validaEntidade(entidade);
    }

    @Override
    public void atualizaVinculos(Drogas entidade) {
        super.atualizaVinculos(entidade);
    }

    @Override
    public void atualizarEntidade(Drogas entidadePersistida, Drogas entidadeAtualizada) throws DrTransferException {
        super.atualizarEntidade(entidadePersistida, entidadeAtualizada);
    }
}

