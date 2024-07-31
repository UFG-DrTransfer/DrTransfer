package br.ufg.inf.backend.drtransfer.service;

import br.ufg.inf.backend.drtransfer.exception.DrTransferException;
import br.ufg.inf.backend.drtransfer.model.Medico;
import br.ufg.inf.backend.drtransfer.repository.MedicoRepository;
import br.ufg.inf.backend.drtransfer.utils.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import static br.ufg.inf.backend.drtransfer.utils.Utils.maiuscula;

@Service
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class MedicoService extends GenericService<Medico, MedicoRepository> {

    @Autowired
    private HospitalService hospitalService;
    @Autowired
    private EspecialidadeService especialidadeService;

    public MedicoService() {
        super("Médico");
    }

    @Override
    protected void padronizaCampos(Medico entidade) throws DrTransferException {
//        maiuscula(entidade, "nome");

    }

    @Override
    protected void validaEntidade(Medico entidade) throws DrTransferException {
        campoObrigatorio(entidade.getNome(), "Nome");
        campoObrigatorio(entidade.getCrm(), "CRM");
        campoObrigatorio(entidade.getHospital(), "Hospital");
        campoObrigatorio(entidade.getEspecialidade(), "Especialidade");
        validaCpf(entidade);
    }

    private void validaCpf(Medico entidade) throws DrTransferException {
        campoObrigatorio(entidade.getCpf(), "Cpf");
        if ((entidade.isNovo() && repository.existsByCpf(entidade.getCpf()))
                || (!entidade.isNovo() && repository.existsByCpfAndIdNot(entidade.getCpf(), entidade.getId()))) {
            throw new DrTransferException(HttpStatus.CONFLICT, CONFLICT, nomeClasse, "CPF");
        }
    }

    @Override
    protected void atualizaVinculos(Medico entidade) throws DrTransferException {
        if (entidade.getHospital() != null) {
            if (entidade.getHospital().isNovo()) {
                throw new DrTransferException(HttpStatus.BAD_REQUEST, ID_INVALIDO, "Hospital");
            } else {
                entidade.setHospital(hospitalService.findByEntidade(entidade.getHospital()));
            }
        }
        if (entidade.getEspecialidade() != null) {
            if (entidade.getEspecialidade().isNovo()) {
                throw new DrTransferException(HttpStatus.BAD_REQUEST, ID_INVALIDO, "Especialidade");
            } else {
                entidade.setEspecialidade(especialidadeService.findByEntidade(entidade.getEspecialidade()));
            }
        }
    }

    @Override
    protected void atualizarEntidade(Medico entidadePersistida, Medico entidadeAtualizada) throws DrTransferException {
        atualizaCampo(entidadePersistida, entidadeAtualizada, "nome");
        atualizaCampo(entidadePersistida, entidadeAtualizada, "email");
        atualizaCampo(entidadePersistida, entidadeAtualizada, "telefone");
        atualizaCampo(entidadePersistida, entidadeAtualizada, "cpf");
        atualizaCampo(entidadePersistida, entidadeAtualizada, "crm");
        atualizaCampo(entidadePersistida, entidadeAtualizada, "sexo");
        atualizaCampo(entidadePersistida, entidadeAtualizada, "ativo");
        atualizaCampo(entidadePersistida, entidadeAtualizada, "hospital");
        atualizaCampo(entidadePersistida, entidadeAtualizada, "especialidade");
    }

}
