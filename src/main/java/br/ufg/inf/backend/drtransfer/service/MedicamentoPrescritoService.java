package br.ufg.inf.backend.drtransfer.service;

import br.ufg.inf.backend.drtransfer.exception.DrTransferException;
import br.ufg.inf.backend.drtransfer.model.MedicamentoPrescrito;
import br.ufg.inf.backend.drtransfer.repository.MedicamentoPrescritoRepository;
import br.ufg.inf.backend.drtransfer.utils.GenericService;
import org.springframework.stereotype.Service;

@Service
public class MedicamentoPrescritoService extends GenericService<MedicamentoPrescrito, MedicamentoPrescritoRepository> {

    public MedicamentoPrescritoService() {
        super("");
    }

    @Override
    protected void padronizaCampos(MedicamentoPrescrito entidade) {

    }

    @Override
    protected void validaEntidade(MedicamentoPrescrito entidade) throws DrTransferException {
        campoObrigatorio(entidade.getProntuario(), "Prontuário");
        campoObrigatorio(entidade.getPosologia(), "Posologia");
        campoObrigatorio(entidade.getDosagem(), "Dosagem");
        campoObrigatorio(entidade.getViaAdministracao(), "Via administração");
        campoObrigatorio(entidade.getUnidadeDosagem(), "Unidade Dosagem");
    }

    @Override
    protected void atualizaVinculos(MedicamentoPrescrito entidade) {
    }

    @Override
    protected void atualizarEntidade(MedicamentoPrescrito entidadePersistida, MedicamentoPrescrito entidadeAtualizada) throws DrTransferException {
        atualizaCampo(entidadePersistida, entidadeAtualizada, "posologia");
        atualizaCampo(entidadePersistida, entidadeAtualizada, "viaAdministracao");
        atualizaCampo(entidadePersistida, entidadeAtualizada, "dosagem");
        atualizaCampo(entidadePersistida, entidadeAtualizada, "unidadeDosagem");
//        if (validaExistente(entidadeAtualizada.getPosologia())) {
//            entidadePersistida.setPosologia(entidadeAtualizada.getPosologia());
//        }
//        if (validaExistente(entidadeAtualizada.getViaAdministracao())) {
//            entidadePersistida.setViaAdministracao(entidadeAtualizada.getViaAdministracao());
//        }
//        if (entidadeAtualizada.getDosagem() != null) {
//            entidadePersistida.setDosagem(entidadeAtualizada.getDosagem());
//        }
//        if (entidadeAtualizada.getUnidadeDosagem() != null) {
//            entidadePersistida.setUnidadeDosagem(entidadeAtualizada.getUnidadeDosagem());
//        }
    }
}
