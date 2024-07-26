package br.ufg.inf.backend.drtransfer.medico;

import br.ufg.inf.backend.drtransfer.exception.DrTransferException;
import br.ufg.inf.backend.drtransfer.model.Especialidade;
import br.ufg.inf.backend.drtransfer.model.Hospital;
import br.ufg.inf.backend.drtransfer.model.Medico;
import br.ufg.inf.backend.drtransfer.repository.MedicoRepository;
import br.ufg.inf.backend.drtransfer.service.EspecialidadeService;
import br.ufg.inf.backend.drtransfer.service.HospitalService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import static br.ufg.inf.backend.drtransfer.utils.GenericService.ID_INVALIDO;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MedicoServiceTeste {

    @Mock
    private HospitalService hospitalService;

    @Mock
    private EspecialidadeService especialidadeService;

    @InjectMocks
    private MedicoServiceTesteHelper medicoService;

    private Medico medico;
    private Hospital hospital;
    private Especialidade especialidade;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        medico = new Medico();
        medico.setNome("Dr. Teste");
        medico.setCrm("123456");

        hospital = new Hospital();
        especialidade = new Especialidade();

        medico.setHospital(hospital);
        medico.setEspecialidade(especialidade);
    }

//    @Test
//    void testPadronizaCampos() throws DrTransferException {
//        medicoService.padronizaCampos(medico);
//        assertEquals("DR. TESTE", medico.getNome());
//    }
//
//    @Test
//    void testValidaEntidade() {
//        assertDoesNotThrow(() -> medicoService.validaEntidade(medico));
//
//        medico.setNome(null);
//        DrTransferException exception = assertThrows(DrTransferException.class, () -> medicoService.validaEntidade(medico));
//        assertEquals("Campo obrigatório não preenchido: Nome", exception.getMessage());
//    }

//    @Test
//    void testAtualizaVinculos() throws DrTransferException {
//        when(hospitalService.findByEntidade(hospital)).thenReturn(hospital);
//        when(especialidadeService.findByEntidade(especialidade)).thenReturn(especialidade);
//
//        medicoService.atualizaVinculos(medico);
//
//        verify(hospitalService, times(1)).findByEntidade(hospital);
//        verify(especialidadeService, times(1)).findByEntidade(especialidade);
//
//        DrTransferException exception = assertThrows(DrTransferException.class, () -> medicoService.atualizaVinculos(medico));
//        assertEquals(HttpStatus.BAD_REQUEST, exception.getStatus());
//        assertEquals(ID_INVALIDO, exception.getMessage());
//    }

    @Test
    void testAtualizarEntidade() throws DrTransferException {
        Medico medicoPersistido = new Medico();
        medicoPersistido.setNome("Dr. Antigo");
        medicoPersistido.setCrm("654321");

        medicoService.atualizarEntidade(medicoPersistido, medico);

        assertEquals("Dr. Teste", medicoPersistido.getNome());
        assertEquals("123456", medicoPersistido.getCrm());
    }
}


