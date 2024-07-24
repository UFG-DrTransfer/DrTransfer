package br.ufg.inf.backend.drtransfer.service;

import br.ufg.inf.backend.drtransfer.model.Paciente;
import br.ufg.inf.backend.drtransfer.repository.PacienteRepository;
import br.ufg.inf.backend.drtransfer.utils.GenericService;
import org.springframework.stereotype.Service;

@Service
public class PacienteService extends GenericService<Paciente, PacienteRepository> {

    public PacienteService() {
        super("Paciente");
    }

    @Override
    protected void padronizaCampos(Paciente entidade) {

    }

    @Override
    protected void validaEntidade(Paciente entidade) {

    }

    @Override
    protected void atualizaVinculos(Paciente entidade) {
//        if(entidade.getProntuario() != null){
//            if(entidade.getProntuario().isNovo()){
//                prontuarioService.atualizaVinculos(entidade.getProntuario());
//                prontuarioService.validaEntidade(entidade.getProntuario());
//            }else{
//                entidade.setProntuario(prontuarioService.findByEntidade(entidade.getProntuario()));
//            }
//        }
    }

    @Override
    protected void atualizarEntidade(Paciente entidadePersistida, Paciente entidadeAtualizada) {

    }
}
