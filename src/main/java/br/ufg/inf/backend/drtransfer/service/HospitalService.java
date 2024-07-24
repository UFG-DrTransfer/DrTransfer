package br.ufg.inf.backend.drtransfer.service;

import br.ufg.inf.backend.drtransfer.exception.DrTransferException;
import br.ufg.inf.backend.drtransfer.model.Hospital;
import br.ufg.inf.backend.drtransfer.repository.HospitalRepository;
import br.ufg.inf.backend.drtransfer.utils.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalService extends GenericService<Hospital, HospitalRepository> {

    public HospitalService() {
        super("Hospital");
    }

	@Override
	protected void padronizaCampos(Hospital entidade) {

	}

	@Override
	protected void validaEntidade(Hospital entidade) {

	}

	@Override
	protected void atualizaVinculos(Hospital entidade) {

	}

	@Override
	protected void atualizarEntidade(Hospital entidadePersistida, Hospital entidadeAtualizada) {

	}
}
