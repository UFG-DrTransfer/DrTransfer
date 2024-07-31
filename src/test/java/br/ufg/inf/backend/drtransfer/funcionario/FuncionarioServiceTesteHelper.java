package br.ufg.inf.backend.drtransfer.funcionario;

import br.ufg.inf.backend.drtransfer.exception.DrTransferException;
import br.ufg.inf.backend.drtransfer.model.Funcionario;
import br.ufg.inf.backend.drtransfer.service.FuncionarioService;

public class FuncionarioServiceTesteHelper extends FuncionarioService {
    public FuncionarioServiceTesteHelper() {
        super();
    }

    @Override
    public void padronizaCampos(Funcionario entidade) throws DrTransferException {
        super.padronizaCampos(entidade);
    }

    @Override
    public void validaEntidade(Funcionario entidade) throws DrTransferException {
        super.validaEntidade(entidade);
    }

    @Override
    public void atualizaVinculos(Funcionario entidade) throws DrTransferException {
        super.atualizaVinculos(entidade);
    }

    @Override
    public void atualizarEntidade(Funcionario entidadePersistida, Funcionario entidadeAtualizada) throws DrTransferException {
        super.atualizarEntidade(entidadePersistida, entidadeAtualizada);
    }
}

