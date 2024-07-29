package br.ufg.inf.backend.drtransfer.service;

import br.ufg.inf.backend.drtransfer.exception.DrTransferException;
import br.ufg.inf.backend.drtransfer.model.Paciente;
import br.ufg.inf.backend.drtransfer.repository.PacienteRepository;
import br.ufg.inf.backend.drtransfer.utils.GenericService;
import br.ufg.inf.backend.drtransfer.utils.formatador.FormatadorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;

import static br.ufg.inf.backend.drtransfer.utils.Utils.maiuscula;


@Service
public class PacienteService extends GenericService<Paciente, PacienteRepository> {

    @Autowired
    private ProntuarioService prontuarioService;

    public PacienteService() {

        super("Paciente");
    }

    @Override
    protected void padronizaCampos(Paciente entidade) throws DrTransferException {
        maiuscula(entidade, "nome");
        if ((entidade.isNovo() && repository.existsByCpf(entidade.getCpf()))
                || (!entidade.isNovo() && repository.existsByCpfAndIdNot(entidade.getCpf(), entidade.getId()))) {
            throw new DrTransferException(HttpStatus.CONFLICT, CONFLICT, nomeClasse, "CPF");
        }
    }

    @Override
    protected void validaEntidade(Paciente entidade) throws DrTransferException {
        campoObrigatorio(entidade.getNome(), "Nome");
        campoObrigatorio(entidade.getCpf(), "CPF");
        campoObrigatorio(entidade.getTipoSanguineo(), "Tipo Sanguineo");
    }

    @Override
    protected void atualizaVinculos(Paciente entidade) throws DrTransferException {
        if(entidade.getProntuario() != null){
            if(entidade.getProntuario().isNovo()){
                entidade.getProntuario().setPaciente(entidade);
                prontuarioService.atualizaVinculos(entidade.getProntuario());
                prontuarioService.validaEntidade(entidade.getProntuario());
            }else{
                entidade.setProntuario(prontuarioService.findByEntidade(entidade.getProntuario()));
            }
        }
    }

    @Override
    protected void atualizarEntidade(Paciente entidadePersistida, Paciente entidadeAtualizada) throws DrTransferException {
        atualizaCampo(entidadePersistida, entidadeAtualizada, "nome");
        atualizaCampo(entidadePersistida, entidadeAtualizada, "cpf");
        atualizaCampo(entidadePersistida, entidadeAtualizada, "telefone");
        atualizaCampo(entidadePersistida, entidadeAtualizada, "email");
        atualizaCampo(entidadePersistida, entidadeAtualizada, "sexo");
        atualizaCampo(entidadePersistida, entidadeAtualizada, "dataNascimento");
        atualizaCampo(entidadePersistida, entidadeAtualizada, "tipoSanguineo");
        atualizaCampo(entidadePersistida, entidadeAtualizada, "prontuario");
    }
}
