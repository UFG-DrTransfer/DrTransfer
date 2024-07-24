package br.ufg.inf.backend.drtransfer.service;

import br.ufg.inf.backend.drtransfer.exception.DrTransferException;
import br.ufg.inf.backend.drtransfer.model.Cargo;
import br.ufg.inf.backend.drtransfer.repository.CargoRepository;
import br.ufg.inf.backend.drtransfer.utils.GenericService;
import static br.ufg.inf.backend.drtransfer.utils.Utils.*;
import org.springframework.stereotype.Service;

@Service
public class CargoService extends GenericService<Cargo, CargoRepository> {

//    @Autowired
//    private MedicoService medicoService;

    public CargoService() {
        super("CargoService");
    }

    @Override
    protected void padronizaCampos(Cargo entidade) throws DrTransferException {
        maiuscula(entidade, "nome");
    }

    @Override
    protected void validaEntidade(Cargo entidade) throws DrTransferException {
        campoObrigatorio(entidade.getNome(), "Nome");
        // TODO: consultar se existe algum cadastro com o nome informado
    }

    @Override
    protected void atualizaVinculos(Cargo entidade) {
    }

    @Override
    protected void atualizarEntidade(Cargo entidadePersistida, Cargo entidadeAtualizada) throws DrTransferException {
        atualizaCampo(entidadePersistida, entidadeAtualizada, "funcao");
        atualizaCampo(entidadePersistida, entidadeAtualizada, "nome");
        atualizaCampo(entidadePersistida, entidadeAtualizada, "ativo");
    }


}
