package br.ufg.inf.backend.drtransfer.service;

import br.ufg.inf.backend.drtransfer.exception.DrTransferException;
import br.ufg.inf.backend.drtransfer.model.Cargo;
import br.ufg.inf.backend.drtransfer.model.Drogas;
import br.ufg.inf.backend.drtransfer.repository.DocumentoTransferenciaRepository;
import br.ufg.inf.backend.drtransfer.repository.DrogasRepository;
import br.ufg.inf.backend.drtransfer.utils.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static br.ufg.inf.backend.drtransfer.utils.Utils.maiuscula;

@Service
public class DrogasService extends GenericService<Drogas, DrogasRepository> {

    public DrogasService() {
        super("Droga");
    }

    @Override
    protected void padronizaCampos(Drogas entidade) throws DrTransferException {
        maiuscula(entidade, "nome");

    }

    @Override
    protected void validaEntidade(Drogas entidade) throws DrTransferException {
        validaNome(entidade);

    }

    private void validaNome(Drogas entidade) throws DrTransferException {
        campoObrigatorio(entidade.getNome(), "Nome");
        if ((entidade.isNovo() && repository.existsByNome(entidade.getNome()))
                || (!entidade.isNovo() && repository.existsByNomeAndIdNot(entidade.getNome(), entidade.getId()))) {
            throw new DrTransferException(HttpStatus.CONFLICT, CONFLICT, nomeClasse, "Nome");
        }
    }


    @Override
    protected void atualizaVinculos(Drogas entidade) {

    }

    @Override
    protected void atualizarEntidade(Drogas entidadePersistida, Drogas entidadeAtualizada) throws DrTransferException {
        atualizaCampo(entidadePersistida, entidadeAtualizada, "nome");
        atualizaCampo(entidadePersistida, entidadeAtualizada, "principioAtivo");
    }
}
