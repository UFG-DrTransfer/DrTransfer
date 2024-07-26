package br.ufg.inf.backend.drtransfer.service;

import br.ufg.inf.backend.drtransfer.exception.DrTransferException;
import br.ufg.inf.backend.drtransfer.model.Funcionario;
import br.ufg.inf.backend.drtransfer.repository.FuncionarioRepository;
import br.ufg.inf.backend.drtransfer.utils.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import static br.ufg.inf.backend.drtransfer.utils.Utils.maiuscula;

@Service
public class FuncionarioService extends GenericService<Funcionario, FuncionarioRepository> {

    @Autowired
    private HospitalService hospitalService;
    @Autowired
    private CargoService cargoService;

    public FuncionarioService() {

        super("Funcionario");
    }


    @Override
    protected void padronizaCampos(Funcionario entidade) throws DrTransferException {
        //maiuscula(entidade, "nome");

    }

    @Override
    protected void validaEntidade(Funcionario entidade) throws DrTransferException {
        campoObrigatorio(entidade.getNome(), "Nome");
        campoObrigatorio(entidade.getNome(), "Hospital");
        campoObrigatorio(entidade.getNome(), "Cargo");

    }

    @Override
    protected void atualizaVinculos(Funcionario entidade) throws DrTransferException {

        if (entidade.getHospital() != null) {
            if (entidade.getHospital().isNovo()) {
                throw new DrTransferException(HttpStatus.BAD_REQUEST, ID_INVALIDO, "Hospital");
            } else {
                entidade.setHospital(hospitalService.findByEntidade(entidade.getHospital()));
            }
        }

        if (entidade.getCargo () != null) {
            if (entidade.getCargo().isNovo()) {
                throw new DrTransferException(HttpStatus.BAD_REQUEST, ID_INVALIDO, "Cargo");
            } else {
                entidade.setCargo(cargoService.findByEntidade(entidade.getCargo()));
            }
        }
    }

    @Override
    protected void atualizarEntidade(Funcionario entidadePersistida, Funcionario entidadeAtualizada) throws DrTransferException {
        atualizaCampo(entidadePersistida, entidadeAtualizada, "nome");
        atualizaCampo(entidadePersistida, entidadeAtualizada, "email");
        atualizaCampo(entidadePersistida, entidadeAtualizada, "telefone");
        atualizaCampo(entidadePersistida, entidadeAtualizada, "cpf");
        atualizaCampo(entidadePersistida, entidadeAtualizada, "cargo");
        atualizaCampo(entidadePersistida, entidadeAtualizada, "sexo");
        atualizaCampo(entidadePersistida, entidadeAtualizada, "ativo");
        atualizaCampo(entidadePersistida, entidadeAtualizada, "hospital");
    }

}
