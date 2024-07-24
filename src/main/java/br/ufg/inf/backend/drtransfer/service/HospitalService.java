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
	protected void validaEntidade(Hospital entidade) throws DrTransferException {
		campoObrigatorio(entidade.getName(),"Nome");
		campoObrigatorio(entidade.getTelephoneNumber(),("Telefone"));
		campoObrigatorio(entidade.getLongitude(),"Longitude");
		campoObrigatorio(entidade.getLatitute(),"Latitude");
		campoObrigatorio(entidade.getEmail(),"Email");
		campoObrigatorio(entidade.isTemUti(),"UTI");
		campoObrigatorio(entidade.getAvailableBeds(),"Leitos Disponíveis");

	}

	@Override
	protected void atualizaVinculos(Hospital entidade) {

	}

	@Override
	protected void atualizarEntidade(Hospital entidadePersistida, Hospital entidadeAtualizada) throws DrTransferException {

		atualizaCampo(entidadePersistida,entidadeAtualizada, "name");
		atualizaCampo(entidadePersistida,entidadeAtualizada, "email");
		atualizaCampo(entidadePersistida,entidadeAtualizada, "telephoneNumber");
		atualizaCampo(entidadePersistida,entidadeAtualizada, "temUti");
		atualizaCampo(entidadePersistida,entidadeAtualizada,"availableBeds");
		atualizaCampo(entidadePersistida, entidadeAtualizada, "ativo");
		atualizaCampo(entidadePersistida,entidadeAtualizada, "longitude");
		atualizaCampo(entidadePersistida,entidadeAtualizada, "latidude");

	}
}
