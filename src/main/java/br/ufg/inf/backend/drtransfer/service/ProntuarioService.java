package br.ufg.inf.backend.drtransfer.service;

import br.ufg.inf.backend.drtransfer.exception.DrTransferException;
import br.ufg.inf.backend.drtransfer.model.MedicamentoPrescrito;
import br.ufg.inf.backend.drtransfer.model.Prontuario;
import br.ufg.inf.backend.drtransfer.repository.ProntuarioRepository;
import br.ufg.inf.backend.drtransfer.utils.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProntuarioService extends GenericService<Prontuario, ProntuarioRepository> {

    @Autowired
    private MedicamentoPrescritoService medicamentoPrescritoService;

    public ProntuarioService() {
        super("Prontuario");
    }

    @Override
    protected void padronizaCampos(Prontuario entidade) {

    }

    @Override
    protected void validaEntidade(Prontuario entidade) throws DrTransferException {
        campoObrigatorio(entidade.getClassificacao(), "Prontuario");
    }

    @Override
    protected void atualizaVinculos(Prontuario entidade) throws DrTransferException {
        if (entidade.getMedicamentoPrescrito() != null) {
            for (MedicamentoPrescrito medicamentoPrescrito : entidade.getMedicamentoPrescrito()) {
                if (medicamentoPrescrito.isNovo()) {
                    medicamentoPrescrito.setProntuario(entidade);
                    medicamentoPrescritoService.validaEntidade(medicamentoPrescrito);
                    medicamentoPrescritoService.atualizaVinculos(medicamentoPrescrito);
                } else {
                    MedicamentoPrescrito medicamentoPersistido = medicamentoPrescritoService.findByEntidade(medicamentoPrescrito);
                    medicamentoPrescritoService.atualizarEntidade(medicamentoPersistido, medicamentoPersistido);
                }
            }
        }
    }

    @Override
    protected void atualizarEntidade(Prontuario entidadePersistida, Prontuario entidadeAtualizada) throws DrTransferException {
        atualizaCampo(entidadePersistida, entidadePersistida, "classificacao");
        if (entidadeAtualizada.getClassificacao() != null) {
            entidadePersistida.setClassificacao(entidadeAtualizada.getClassificacao());
        }
    }
}
