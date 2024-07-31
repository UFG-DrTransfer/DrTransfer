package br.ufg.inf.backend.drtransfer.service;


import br.ufg.inf.backend.drtransfer.exception.DrTransferException;
import br.ufg.inf.backend.drtransfer.model.Hospital;
import br.ufg.inf.backend.drtransfer.model.Transferencia;
import br.ufg.inf.backend.drtransfer.repository.TransferenciaRepository;
import br.ufg.inf.backend.drtransfer.utils.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public class TransferenciaService extends GenericService<Transferencia, TransferenciaRepository> {

    @Autowired
    private SolicitacaoService solicitacaoService;
    @Autowired
    private MedicoService medicoService;
    @Autowired
    private MedicoReguladorService medicoReguladorService;
    @Autowired
    private RouteService routeService;


    public TransferenciaService(MedicoReguladorService medicoReguladorService) {
        super("Transferencia");
        this.medicoReguladorService = medicoReguladorService;
    }


    @Override
    protected void padronizaCampos(Transferencia entidade) throws DrTransferException {

    }

    @Override
    protected void validaEntidade(Transferencia entidade) throws DrTransferException {
        campoObrigatorio(entidade.getMeioTransporte(), "Meio de Transporte");
        campoObrigatorio(entidade.getSolicitacao(), "Solicitacao");
        campoObrigatorio(entidade.getMedicoRegulador(), "Medico Regulador");
        campoObrigatorio(entidade.getMedicoDestino(), "Médico destino");
        Hospital origem = entidade.getHospitalOrigem();
        Hospital destino = entidade.getHospitalDestino();
        Map<String, Long> rotas = routeService.getRoute(origem.getLatitute(), origem.getLongitude(), destino.getLatitute(), destino.getLongitude());
        if (rotas != null) {
            Long distancia = rotas.get("distancia");
            long duracao = rotas.get("duracao");
            entidade.setDistancia(distancia.doubleValue() / 1000);
            System.out.printf("Distancia: ", distancia);
            LocalDateTime horaSaida = entidade.getHorarioSaida();
            LocalDateTime horarioPrevistoChegada = horaSaida.plusSeconds(duracao);
            entidade.setHorarioPrevistoChegada(horarioPrevistoChegada);
            System.out.printf("Horario chegada: ", horarioPrevistoChegada);
        }
    }

    @Override
    protected void atualizaVinculos(Transferencia entidade) throws DrTransferException {
        if (entidade.getSolicitacao() != null) {
            if (entidade.getSolicitacao().isNovo()) {
                throw new DrTransferException(HttpStatus.BAD_REQUEST, ID_INVALIDO, "Solicitação");
            } else {
                entidade.setSolicitacao(solicitacaoService.findByEntidade(entidade.getSolicitacao()));
                entidade.setPaciente(entidade.getSolicitacao().getPaciente());
                entidade.setMedicoOrigem(entidade.getSolicitacao().getMedico());
                entidade.setHospitalOrigem(entidade.getSolicitacao().getMedico().getHospital());
                entidade.setDocumento(entidade.getSolicitacao().getDocumento());
            }
        }

        if (entidade.getMedicoRegulador() != null) {
            if (entidade.getMedicoRegulador().isNovo()) {
                throw new DrTransferException(HttpStatus.BAD_REQUEST, ID_INVALIDO, "Medico Regulador");
            } else {
                entidade.setMedicoRegulador(medicoReguladorService.findByEntidade(entidade.getMedicoRegulador()));
            }
        }

        if (entidade.getMedicoDestino() != null) {
            if (entidade.getMedicoDestino().isNovo()) {
                throw new DrTransferException(HttpStatus.BAD_REQUEST, ID_INVALIDO, "Medico Destino");
            } else {
                entidade.setMedicoDestino(medicoService.findByEntidade(entidade.getMedicoDestino()));
                entidade.setHospitalDestino(entidade.getMedicoDestino().getHospital());

            }
        }


    }

    @Override
    protected void atualizarEntidade(Transferencia entidadePersistida, Transferencia entidadeAtualizada) throws DrTransferException {
        atualizaCampo(entidadePersistida, entidadeAtualizada, "meioTransporte");
        atualizaCampo(entidadePersistida, entidadeAtualizada, "horarioSaida");
        atualizaCampo(entidadePersistida, entidadeAtualizada, "horarioPrevistoChegada");
        atualizaCampo(entidadePersistida, entidadeAtualizada, "distancia");
        atualizaCampo(entidadePersistida, entidadeAtualizada, "medicoRegulador");
        atualizaCampo(entidadePersistida, entidadeAtualizada, "medicoDestino");
        atualizaCampo(entidadePersistida, entidadeAtualizada, "hospitalDestino");
        atualizaCampo(entidadePersistida, entidadeAtualizada, "solicitacao");

    }
}
