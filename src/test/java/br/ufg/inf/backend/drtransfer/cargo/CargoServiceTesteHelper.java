package br.ufg.inf.backend.drtransfer.cargo;

import br.ufg.inf.backend.drtransfer.exception.DrTransferException;
import br.ufg.inf.backend.drtransfer.model.Cargo;
import br.ufg.inf.backend.drtransfer.service.CargoService;

public class CargoServiceTesteHelper extends CargoService {
    public CargoServiceTesteHelper() {
        super();
    }

    @Override
    public void padronizaCampos(Cargo entidade) throws DrTransferException {
        super.padronizaCampos(entidade);
    }

    @Override
    public void validaEntidade(Cargo entidade) throws DrTransferException {
        super.validaEntidade(entidade);
    }

    @Override
    public void atualizaVinculos(Cargo entidade) {
        super.atualizaVinculos(entidade);
    }

    @Override
    public void atualizarEntidade(Cargo entidadePersistida, Cargo entidadeAtualizada) throws DrTransferException {
        super.atualizarEntidade(entidadePersistida, entidadeAtualizada);
    }
}
