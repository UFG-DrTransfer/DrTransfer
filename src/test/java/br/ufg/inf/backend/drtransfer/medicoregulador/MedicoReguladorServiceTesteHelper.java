package br.ufg.inf.backend.drtransfer.medicoregulador;

import br.ufg.inf.backend.drtransfer.exception.DrTransferException;
import br.ufg.inf.backend.drtransfer.model.MedicoRegulador;
import br.ufg.inf.backend.drtransfer.service.MedicoReguladorService;

public class MedicoReguladorServiceTesteHelper extends MedicoReguladorService {
    public MedicoReguladorServiceTesteHelper() {
        super();
    }

    @Override
    public void padronizaCampos(MedicoRegulador entidade) throws DrTransferException {
        super.padronizaCampos(entidade);
    }

    @Override
    public void validaEntidade(MedicoRegulador entidade) throws DrTransferException {
        super.validaEntidade(entidade);
    }

    @Override
    public void atualizaVinculos(MedicoRegulador entidade) throws DrTransferException {
        super.atualizaVinculos(entidade);
    }

    @Override
    public void atualizarEntidade(MedicoRegulador entidadePersistida, MedicoRegulador entidadeAtualizada) throws DrTransferException {
        super.atualizarEntidade(entidadePersistida, entidadeAtualizada);
    }
}
