package br.ufg.inf.backend.drtransfer.service;

import br.ufg.inf.backend.drtransfer.exception.DrTransferException;
import br.ufg.inf.backend.drtransfer.model.DocumentoTransferencia;
import br.ufg.inf.backend.drtransfer.repository.DocumentoTransferenciaRepository;
import br.ufg.inf.backend.drtransfer.repository.HospitalRepository;
import br.ufg.inf.backend.drtransfer.utils.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentoTransferenciaService extends GenericService<DocumentoTransferencia, DocumentoTransferenciaRepository> {

    @Autowired
    private DocumentoTransferenciaRepository repository;

    public DocumentoTransferenciaService() {
        super("DocumentoTransferencia");
    }


    @Override
    protected void atualizarEntidade(DocumentoTransferencia entidadePersistida, DocumentoTransferencia entidadeAtualizada) throws DrTransferException {
        atualizaCampo(entidadePersistida, entidadeAtualizada, "documento");
        atualizaCampo(entidadePersistida, entidadeAtualizada, "observacao");
    }

    @Override
    protected void padronizaCampos(DocumentoTransferencia entidade) {

    }

    @Override
    protected void validaEntidade(DocumentoTransferencia entidade) {

    }

    @Override
    protected void atualizaVinculos(DocumentoTransferencia entidade) {

    }
}

