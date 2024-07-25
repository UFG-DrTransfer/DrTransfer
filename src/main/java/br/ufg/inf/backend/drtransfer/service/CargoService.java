package br.ufg.inf.backend.drtransfer.service;

import br.ufg.inf.backend.drtransfer.exception.DrTransferException;
import br.ufg.inf.backend.drtransfer.model.Cargo;
import br.ufg.inf.backend.drtransfer.repository.CargoRepository;
import br.ufg.inf.backend.drtransfer.utils.GenericService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static br.ufg.inf.backend.drtransfer.utils.Utils.maiuscula;

@Service
public class CargoService extends GenericService<Cargo, CargoRepository> {

//    @Autowired
//    private MedicoService medicoService;

    public CargoService() {
        super("Cargo");
    }

    @Override
    protected void padronizaCampos(Cargo entidade) throws DrTransferException {
        maiuscula(entidade, "nome");
    }

    @Override
    protected void validaEntidade(Cargo entidade) throws DrTransferException {
        validaNome(entidade);
    }

    private void validaNome(Cargo entidade) throws DrTransferException {
        campoObrigatorio(entidade.getNome(), "Nome");
        if ((entidade.isNovo() && repository.existsByNome(entidade.getNome()))
                || (!entidade.isNovo() && repository.existsByNomeAndIdNot(entidade.getNome(), entidade.getId()))) {
            throw new DrTransferException(HttpStatus.CONFLICT, CONFLICT, nomeClasse, "Nome");
        }
    }

    @Override
    protected void atualizaVinculos(Cargo entidade) {
    }

    @Override
    protected void atualizarEntidade(Cargo entidadePersistida, Cargo entidadeAtualizada) throws DrTransferException {
        atualizaCampo(entidadePersistida, entidadeAtualizada, "nome");
        atualizaCampo(entidadePersistida, entidadeAtualizada, "ativo");
    }


}
