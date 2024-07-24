package br.ufg.inf.backend.drtransfer.service;

import br.ufg.inf.backend.drtransfer.exception.DrTransferException;
import br.ufg.inf.backend.drtransfer.model.Medico;
import br.ufg.inf.backend.drtransfer.repository.MedicoRepository;
import br.ufg.inf.backend.drtransfer.utils.GenericService;
import org.springframework.beans.factory.annotation.Autowired;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class MedicoService extends GenericService<Medico, MedicoRepository> {

    public static final String ID_INVALIDO = "É necessário passar o identificador do(a) %s";
    @Autowired
    private HospitalService hospitalService;
    @Autowired
    private EspecialidadeService especialidadeService;

    public MedicoService() {
        super("Médico");
    }

    @Override
    protected void padronizaCampos(Medico entidade) {

    }

    @Override
    protected void validaEntidade(Medico entidade) throws DrTransferException {
        campoObrigatorio(entidade.getNome(), "Nome");
        campoObrigatorio(entidade.getNome(), "CRM");


//        if (!validaExistente(entidade.getNome())) {
//            throw new DrTransferException(" 'Nome' é obrigatório");
//        }
//        if (!validaExistente(entidade.getCrm())) {
//            throw new DrTransferException(" 'CRM' é obrigatório");
//        }
    }

    @Override
    protected void atualizaVinculos(Medico entidade) throws DrTransferException {
        if (entidade.getHospital() != null) {
            if (entidade.getHospital().isNovo()) {
                throw new DrTransferException(ID_INVALIDO, "Hospital");
            } else {
                entidade.setHospital(hospitalService.findByEntidade(entidade.getHospital()));
            }
        }
        if (entidade.getEspecialidade() != null) {
            if (entidade.getEspecialidade().isNovo()) {
                throw new DrTransferException(ID_INVALIDO, "Especialidade");
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
//        if (validaExistente(entidadeAtualizada.getNome())) {
//            entidadePersistida.setNome(entidadeAtualizada.getNome());
//        }
//        if (validaExistente(entidadeAtualizada.getEmail())) {
//            entidadePersistida.setEmail(entidadeAtualizada.getEmail());
//        }
//        if (validaExistente(entidadeAtualizada.getTelefone())) {
//            entidadePersistida.setTelefone(entidadeAtualizada.getTelefone());
//        }
//        if (validaExistente(entidadeAtualizada.getCpf())) {
//            entidadePersistida.setCpf(entidadeAtualizada.getCpf());
//        }
//        if (validaExistente(entidadeAtualizada.getCrm())) {
//            entidadePersistida.setCrm(entidadeAtualizada.getCrm());
//        }
//        if (entidadeAtualizada.getSexo() != null) {
//            entidadePersistida.setSexo(entidadeAtualizada.getSexo());
//        }
//        if (entidadeAtualizada.getAtivo() != null) {
//            entidadePersistida.setAtivo(entidadeAtualizada.getAtivo());
//        }
//        if (entidadeAtualizada.getHospital() != null) {
//            entidadePersistida.setHospital(entidadeAtualizada.getHospital());
//        }
//        if (entidadeAtualizada.getEspecialidade() != null) {
//            entidadePersistida.setEspecialidade(entidadeAtualizada.getEspecialidade());
//        }
    }

}
