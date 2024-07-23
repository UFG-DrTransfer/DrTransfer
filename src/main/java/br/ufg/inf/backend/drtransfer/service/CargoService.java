package br.ufg.inf.backend.drtransfer.service;

import br.ufg.inf.backend.drtransfer.exception.DrTransferException;
import br.ufg.inf.backend.drtransfer.model.Cargo;
import br.ufg.inf.backend.drtransfer.repository.CargoRepository;
import br.ufg.inf.backend.drtransfer.utils.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CargoService extends GenericService<Cargo, CargoRepository> {

//    @Autowired
//    private MedicoService medicoService;

    public CargoService() {
        super("CargoService");
    }

    @Override
    protected void atualizaVinculos(Cargo entidade) {

    }

    @Override
    protected void atualizarEntidade(Cargo entidadePersistida, Cargo entidadeAtualizada) {
        if (validaString(entidadeAtualizada.getFuncao())) {
            entidadePersistida.setFuncao(entidadeAtualizada.getFuncao());
        }
        if (validaString(entidadeAtualizada.getNome())) {
            entidadePersistida.setNome(entidadeAtualizada.getNome());
        }
        if (entidadeAtualizada.getAtivo() != null) {
            entidadePersistida.setAtivo(entidadeAtualizada.getAtivo());
        }
    }

    @Override
    protected void validaEntidade(Cargo entidade) {
        if (!validaString(entidade.getFuncao()))
            throw new DrTransferException(" 'Função' é obrigatório");

        if (!validaString(entidade.getNome()))
            throw new DrTransferException(" 'Nome' é obrigatório");
    }


}
