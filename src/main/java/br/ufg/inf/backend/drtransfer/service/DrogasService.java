package br.ufg.inf.backend.drtransfer.service;

import br.ufg.inf.backend.drtransfer.exception.DrTransferException;
import br.ufg.inf.backend.drtransfer.model.Drogas;
import br.ufg.inf.backend.drtransfer.repository.DocumentoTransferenciaRepository;
import br.ufg.inf.backend.drtransfer.repository.DrogasRepository;
import br.ufg.inf.backend.drtransfer.utils.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DrogasService extends GenericService<Drogas, DrogasRepository> {

    public DrogasService() {
        super("Droga");
    }

    @Override
    protected void padronizaCampos(Drogas entidade) {

    }

    @Override
    protected void validaEntidade(Drogas entidade) {

    }

    @Override
    protected void atualizaVinculos(Drogas entidade) {

    }

    @Override
    protected void atualizarEntidade(Drogas entidadePersistida, Drogas entidadeAtualizada) {

    }
}
