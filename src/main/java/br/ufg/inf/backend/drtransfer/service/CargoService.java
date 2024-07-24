package br.ufg.inf.backend.drtransfer.service;

import br.ufg.inf.backend.drtransfer.exception.DrTransferException;
import br.ufg.inf.backend.drtransfer.model.Cargo;
import br.ufg.inf.backend.drtransfer.repository.CargoRepository;
import br.ufg.inf.backend.drtransfer.utils.GenericService;
import org.springframework.stereotype.Service;

@Service
public class CargoService extends GenericService<Cargo, CargoRepository> {

//    @Autowired
//    private MedicoService medicoService;

    public CargoService() {
        super("CargoService");
    }

    @Override
    protected void padronizaCampos(Cargo entidade) {

    }

    @Override
    protected void validaEntidade(Cargo entidade) throws DrTransferException {
        campoObrigatorio(entidade.getFuncao(), "Função");
        if (!validaExistente(entidade.getFuncao()))
            throw new DrTransferException(" 'Função' é obrigatório");

        if (!validaExistente(entidade.getNome()))
            throw new DrTransferException(" 'Nome' é obrigatório");
    }

    @Override
    protected void atualizaVinculos(Cargo entidade) {
    }

    @Override
    protected void atualizarEntidade(Cargo entidadePersistida, Cargo entidadeAtualizada) throws DrTransferException {
        atualizaCampo(entidadePersistida, entidadeAtualizada, "funcao");
        atualizaCampo(entidadePersistida, entidadeAtualizada, "nome");
        atualizaCampo(entidadePersistida, entidadeAtualizada, "ativo");
//        if (validaExistente(entidadeAtualizada.getFuncao())) {
//            entidadePersistida.setFuncao(entidadeAtualizada.getFuncao());
//        }
//        if (validaExistente(entidadeAtualizada.getNome())) {
//            entidadePersistida.setNome(entidadeAtualizada.getNome());
//        }
//        if (entidadeAtualizada.getAtivo() != null) {
//            entidadePersistida.setAtivo(entidadeAtualizada.getAtivo());
//        }
    }


}
