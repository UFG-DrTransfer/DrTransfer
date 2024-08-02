package br.ufg.inf.backend.drtransfer.service;

import br.ufg.inf.backend.drtransfer.exception.DrTransferException;
import br.ufg.inf.backend.drtransfer.model.Hospital;
import br.ufg.inf.backend.drtransfer.repository.HospitalRepository;
import br.ufg.inf.backend.drtransfer.utils.GenericService;
import org.springframework.stereotype.Service;

import static br.ufg.inf.backend.drtransfer.utils.Utils.maiuscula;

@Service
public class HospitalService extends GenericService<Hospital, HospitalRepository> {

    public HospitalService() {
        super("Hospital");
    }

	@Override
	protected void padronizaCampos(Hospital entidade) throws DrTransferException {
		maiuscula(entidade, "nome");
	}

	@Override
	protected void validaEntidade(Hospital entidade) throws DrTransferException {

		validaNome(entidade);
		campoObrigatorio(entidade.getTelephoneNumber(),("Telefone"));
		campoObrigatorio(entidade.getLongitude(),"Longitude");
		campoObrigatorio(entidade.getLatitude(),"Latitude");
		campoObrigatorio(entidade.getEmail(),"Email");
		campoObrigatorio(entidade.getTemUti(),"UTI");
		campoObrigatorio(entidade.getAvailableBeds(),"Leitos Disponíveis");

	}

	private void validaNome(Hospital entidade) throws DrTransferException {

		campoObrigatorio(entidade.getNome(),"Nome");
		//TODO: validar caracteres mínimos
		//TODO: validar se tem números no nome
	}


	@Override
	protected void atualizaVinculos(Hospital entidade) {

	}

	@Override
	protected void atualizarEntidade(Hospital entidadePersistida, Hospital entidadeAtualizada) throws DrTransferException {

		atualizaCampo(entidadePersistida,entidadeAtualizada, "nome");
		atualizaCampo(entidadePersistida,entidadeAtualizada, "email");
		atualizaCampo(entidadePersistida,entidadeAtualizada, "telephoneNumber");
		atualizaCampo(entidadePersistida,entidadeAtualizada, "temUti");
		atualizaCampo(entidadePersistida,entidadeAtualizada,"availableBeds");
		atualizaCampo(entidadePersistida, entidadeAtualizada, "ativo");
		atualizaCampo(entidadePersistida,entidadeAtualizada, "longitude");
		atualizaCampo(entidadePersistida,entidadeAtualizada, "latitude");

	}
}
