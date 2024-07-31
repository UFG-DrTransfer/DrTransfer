package br.ufg.inf.backend.drtransfer.funcionario;

import br.ufg.inf.backend.drtransfer.exception.DrTransferException;
import br.ufg.inf.backend.drtransfer.model.Cargo;
import br.ufg.inf.backend.drtransfer.model.Funcionario;
import br.ufg.inf.backend.drtransfer.model.Hospital;
import br.ufg.inf.backend.drtransfer.repository.FuncionarioRepository;
import br.ufg.inf.backend.drtransfer.service.CargoService;
import br.ufg.inf.backend.drtransfer.service.HospitalService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FuncionarioServiceTeste {

    @Mock
    private FuncionarioRepository funcionarioRepository;

    @Mock
    private HospitalService hospitalService;

    @Mock
    private CargoService cargoService;

    @InjectMocks
    private FuncionarioServiceTesteHelper funcionarioService;

    private Funcionario funcionario;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        funcionario = new Funcionario();
        funcionario.setNome("João Silva");
        funcionario.setHospital(new Hospital());
        funcionario.setCargo(new Cargo());
    }

    @Test
    void testPadronizaCampos() throws DrTransferException {
        // Testa se padronizaCampos faz a formatação correta (se aplicável)
        funcionarioService.padronizaCampos(funcionario);
        // Como o método não altera nenhum campo, não há asserts específicos a fazer.
    }

    @Test
    void testValidaEntidade() {
        assertDoesNotThrow(() -> funcionarioService.validaEntidade(funcionario));

        funcionario.setNome(null);
        DrTransferException exception = assertThrows(DrTransferException.class, () -> funcionarioService.validaEntidade(funcionario));
        assertEquals("Funcionario contém o campo Nome que é obrigatório.", exception.getMessage());
    }

    @Test
    void testAtualizaVinculos() throws DrTransferException {
        Hospital hospital = new Hospital();
        hospital.setId(1L);
        Cargo cargo = new Cargo();
        cargo.setId(1L);

        funcionario.setHospital(hospital);
        funcionario.setCargo(cargo);

        when(hospitalService.findByEntidade(hospital)).thenReturn(hospital);
        when(cargoService.findByEntidade(cargo)).thenReturn(cargo);

        assertDoesNotThrow(() -> funcionarioService.atualizaVinculos(funcionario));
        verify(hospitalService).findByEntidade(hospital);
        verify(cargoService).findByEntidade(cargo);

        Hospital novoHospital = new Hospital();
        novoHospital.setId(null); // Hospital novo, ID inválido
        funcionario.setHospital(novoHospital);

        DrTransferException exception = assertThrows(DrTransferException.class, () -> funcionarioService.atualizaVinculos(funcionario));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getStatus());
        assertEquals("É necessário passar o identificador do(a) Hospital", exception.getMessage());
    }

    @Test
    void testAtualizarEntidade() throws DrTransferException {
        Funcionario funcionarioPersistido = new Funcionario();
        funcionarioPersistido.setNome("Maria Souza");
        funcionarioPersistido.setEmail("maria@example.com");

        funcionario.setNome("João Silva");
        funcionario.setEmail("joao@example.com");

        funcionarioService.atualizarEntidade(funcionarioPersistido, funcionario);

        assertEquals("João Silva", funcionarioPersistido.getNome());
        assertEquals("joao@example.com", funcionarioPersistido.getEmail());
    }
}

