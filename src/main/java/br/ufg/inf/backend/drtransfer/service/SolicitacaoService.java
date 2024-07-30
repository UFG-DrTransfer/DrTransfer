package br.ufg.inf.backend.drtransfer.service;

import br.ufg.inf.backend.drtransfer.exception.DrTransferException;
import br.ufg.inf.backend.drtransfer.model.*;
import br.ufg.inf.backend.drtransfer.repository.SolicitacaoRepository;
import br.ufg.inf.backend.drtransfer.utils.GenericService;
import br.ufg.inf.backend.drtransfer.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")

public class SolicitacaoService extends GenericService<Solicitacao, SolicitacaoRepository> {
    @Autowired
    private EspecialidadeService especialidadeService;
    @Autowired
    private MedicoService medicoService;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private DocumentoTransferenciaService documentoTransferenciaService;

    public SolicitacaoService(EspecialidadeService especialidadeService, MedicoService medicoService) {
        super("Solicitação de Transferência");

    }

    @Override
    protected void padronizaCampos(Solicitacao entidade) throws DrTransferException {

    }

    @Override
    protected void validaEntidade(Solicitacao entidade) throws DrTransferException {
        campoObrigatorio(entidade.getEspecialidade(), "especialidade");
        campoObrigatorio(entidade.getMedico(), "medico");
        campoObrigatorio(entidade.getPaciente(), "paciente");
        campoObrigatorio(entidade.getDocumento(), "documento");
    }

    @Override
    protected void atualizaVinculos(Solicitacao entidade) throws DrTransferException {

        if (entidade.getEspecialidade() != null) {
            if (entidade.getEspecialidade().isNovo()) {
                throw new DrTransferException(HttpStatus.BAD_REQUEST, ID_INVALIDO, "Especialidade");
            } else {
                entidade.setEspecialidade(especialidadeService.findByEntidade(entidade.getEspecialidade()));
            }
        }

        if (entidade.getMedico() != null) {
            if (entidade.getMedico().isNovo()) {
                throw new DrTransferException(HttpStatus.BAD_REQUEST, ID_INVALIDO, "Médico");
            } else {
                entidade.setMedico(medicoService.findByEntidade(entidade.getMedico()));
            }
        }

        if (entidade.getPaciente() != null) {
            if (entidade.getPaciente().isNovo()) {
                throw new DrTransferException(HttpStatus.BAD_REQUEST, ID_INVALIDO, "Paciente");
            } else {
                entidade.setPaciente(pacienteService.findByEntidade(entidade.getPaciente()));
            }
        }

        if (entidade.getDocumento() != null) {
            if (entidade.getDocumento().isNovo()) {
                entidade.getDocumento().setSolicitacao(entidade);
                documentoTransferenciaService.validaEntidade(entidade.getDocumento());
                documentoTransferenciaService.atualizaVinculos(entidade.getDocumento());
            } else {
                entidade.setDocumento(documentoTransferenciaService.findByEntidade(entidade.getDocumento()));
            }
        }

    }

    @Override
    protected void atualizarEntidade(Solicitacao entidadePersistida, Solicitacao entidadeAtualizada) throws
            DrTransferException {
        atualizaCampo(entidadePersistida, entidadeAtualizada, "motivo");
        atualizaCampo(entidadePersistida, entidadeAtualizada, "horaSolicitacao");

    }
}
