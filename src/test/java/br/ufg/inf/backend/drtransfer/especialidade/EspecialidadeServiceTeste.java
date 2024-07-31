package br.ufg.inf.backend.drtransfer.especialidade;

import br.ufg.inf.backend.drtransfer.exception.DrTransferException;
import br.ufg.inf.backend.drtransfer.model.Especialidade;
import br.ufg.inf.backend.drtransfer.repository.EspecialidadeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
public class EspecialidadeServiceTeste {

    @Mock
    private EspecialidadeRepository especialidadeRepository;

    @InjectMocks
    private EspecialidadeServiceTesteHelper especialidadeService;

    private Especialidade especialidade;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        especialidade = new Especialidade();
        especialidade.setNome("Cardiologia");
        especialidade.setDescricao("Especialidade médica focada no sistema cardiovascular.");
    }

    @Test
    void testPadronizaCampos() throws DrTransferException {
        especialidadeService.padronizaCampos(especialidade);
        assertEquals("CARDIOLOGIA", especialidade.getNome());
        assertEquals("ESPECIALIDADE MÉDICA FOCADA NO SISTEMA CARDIOVASCULAR.", especialidade.getDescricao());
    }

    @Test
    void testValidaEntidade() {
        assertDoesNotThrow(() -> especialidadeService.validaEntidade(especialidade));

        especialidade.setNome(null);
        DrTransferException exception = assertThrows(DrTransferException.class, () -> especialidadeService.validaEntidade(especialidade));
        assertEquals("Especialidade contém o campo Nome que é obrigatório.", exception.getMessage());
    }

    @Test
    void testAtualizaVinculos() {
        assertDoesNotThrow(() -> especialidadeService.atualizaVinculos(especialidade));
    }

    @Test
    void testAtualizarEntidade() throws DrTransferException {
        Especialidade especialidadePersistida = new Especialidade();
        especialidadePersistida.setNome("Ortopedia");
        especialidadePersistida.setDescricao("Especialidade médica focada no sistema músculo-esquelético.");

        especialidade.setNome("Cardiologia");
        especialidade.setDescricao("Especialidade médica focada no sistema cardiovascular.");

        especialidadeService.atualizarEntidade(especialidadePersistida, especialidade);

        assertEquals("Cardiologia", especialidadePersistida.getNome());
        assertEquals("Especialidade médica focada no sistema cardiovascular.", especialidadePersistida.getDescricao());
    }
}

