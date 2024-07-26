package br.ufg.inf.backend.drtransfer.service;

import br.ufg.inf.backend.drtransfer.enumeradores.MeioTransporte;
import br.ufg.inf.backend.drtransfer.exception.DrTransferException;
import br.ufg.inf.backend.drtransfer.model.Transferencia;
import br.ufg.inf.backend.drtransfer.repository.TransferenciaRepository;
import br.ufg.inf.backend.drtransfer.utils.GenericService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Service
public class TransferenciaService extends GenericService<Transferencia, TransferenciaRepository> {
    public TransferenciaService() {
        super("Transferencia");
    }


//    private MeioTransporte meioTransporte;
//    private LocalDateTime horarioSaida;
//    private LocalDateTime horarioPrevistoChegada;
//    private Double distancia;

    @Override
    protected void padronizaCampos(Transferencia entidade) throws DrTransferException {

    }

    @Override
    protected void validaEntidade(Transferencia entidade) throws DrTransferException {

    }

    @Override
    protected void atualizaVinculos(Transferencia entidade) throws DrTransferException {

    }

    @Override
    protected void atualizarEntidade(Transferencia entidadePersistida, Transferencia entidadeAtualizada) throws DrTransferException {
        atualizaCampo(entidadePersistida, entidadeAtualizada, "horarioSaida");
    }
}
