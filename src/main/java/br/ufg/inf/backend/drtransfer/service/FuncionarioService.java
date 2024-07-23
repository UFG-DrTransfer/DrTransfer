package br.ufg.inf.backend.drtransfer.service;

import br.ufg.inf.backend.drtransfer.model.Funcionario;
import br.ufg.inf.backend.drtransfer.repository.FuncionarioRepository;
import br.ufg.inf.backend.drtransfer.utils.GenericService;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService extends GenericService<Funcionario, FuncionarioRepository> {
    public FuncionarioService() {
        super("Funcionario");
    }

    @Override
    protected void atualizarEntidade(Funcionario entidadePersistida, Funcionario entidadeAtualizada) {

    }

    @Override
    protected void validaEntidade(Funcionario entidade) {

    }

    @Override
    protected void atualizaVinculos(Funcionario entidade) {

    }
}
