package br.ufg.inf.backend.drtransfer.service;

import br.ufg.inf.backend.drtransfer.exception.DrTransferException;
import br.ufg.inf.backend.drtransfer.model.Cargo;
import br.ufg.inf.backend.drtransfer.repository.CargoRepository;
import br.ufg.inf.backend.drtransfer.utils.GenericService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CargoService extends GenericService<Cargo, CargoRepository> {

    public CargoService() {
        super("CargoService");
    }

    @Override
    protected void atualizarEntidade(Cargo entidadePersistida, Cargo entidadeAtualizada) {
        entidadePersistida.setFuncao(entidadeAtualizada.getFuncao());
        entidadePersistida.setNome(entidadeAtualizada.getNome());
    }

    @Override
    protected void validaEntidade(Cargo entidade) {

    }
}
