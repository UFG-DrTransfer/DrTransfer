package br.ufg.inf.backend.drtransfer.service;

import br.ufg.inf.backend.drtransfer.exception.DrTransferException;
import br.ufg.inf.backend.drtransfer.model.MedicoRegulador;
import br.ufg.inf.backend.drtransfer.repository.MedicoReguladorRepository;
import br.ufg.inf.backend.drtransfer.utils.GenericService;
import org.springframework.stereotype.Service;

import static br.ufg.inf.backend.drtransfer.utils.Utils.maiuscula;

@Service
public class MedicoReguladorService extends GenericService<MedicoRegulador, MedicoReguladorRepository> {
    public MedicoReguladorService() {
        super("Medico Regulador");
    }

    @Override
    protected void padronizaCampos(MedicoRegulador entidade) throws DrTransferException {
        maiuscula(entidade, "nome");
        maiuscula(entidade, "crm");
    }

    @Override
    protected void validaEntidade(MedicoRegulador entidade) throws DrTransferException {
        campoObrigatorio(entidade.getNome(), "CRM");

    }

    @Override
    protected void atualizaVinculos(MedicoRegulador entidade) throws DrTransferException {

    }

    @Override
    protected void atualizarEntidade(MedicoRegulador entidadePersistida, MedicoRegulador entidadeAtualizada) throws DrTransferException {
        atualizaCampo(entidadePersistida, entidadeAtualizada, "nome");
        atualizaCampo(entidadePersistida, entidadeAtualizada, "email");
        atualizaCampo(entidadePersistida, entidadeAtualizada, "telefone");
        atualizaCampo(entidadePersistida, entidadeAtualizada, "cpf");
        atualizaCampo(entidadePersistida, entidadeAtualizada, "crm");
        atualizaCampo(entidadePersistida, entidadeAtualizada, "sexo");
        atualizaCampo(entidadePersistida, entidadeAtualizada, "ativo");
    }
}
