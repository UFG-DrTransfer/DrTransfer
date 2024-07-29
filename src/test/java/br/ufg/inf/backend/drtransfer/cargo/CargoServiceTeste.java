package br.ufg.inf.backend.drtransfer.cargo;

import br.ufg.inf.backend.drtransfer.exception.DrTransferException;
import br.ufg.inf.backend.drtransfer.model.Cargo;
import br.ufg.inf.backend.drtransfer.repository.CargoRepository;
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
public class CargoServiceTeste {

    @Mock
    private CargoRepository cargoRepository;

    @InjectMocks
    private CargoServiceTesteHelper cargoService;

    private Cargo cargo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        cargo = new Cargo();
        cargo.setNome("Gerente");
    }

    @Test
    void testPadronizaCampos() throws DrTransferException {
        cargoService.padronizaCampos(cargo);
        assertEquals("GERENTE", cargo.getNome());
    }

//    @Test
//    void testValidaEntidade() {
//        when(cargoRepository.existsByNome(cargo.getNome())).thenReturn(false);
//        assertDoesNotThrow(() -> cargoService.validaEntidade(cargo));
//
//        cargo.setNome(null);
//        DrTransferException exception = assertThrows(DrTransferException.class, () -> cargoService.validaEntidade(cargo));
//        assertEquals("Campo obrigatório não preenchido: Nome", exception.getMessage());
//
//        cargo.setNome("Gerente");
//        //cargo.setNovo(true);
//        when(cargoRepository.existsByNome(cargo.getNome())).thenReturn(true);
//        exception = assertThrows(DrTransferException.class, () -> cargoService.validaEntidade(cargo));
//        assertEquals(HttpStatus.CONFLICT, exception.getStatus());
//        assertEquals("Conflito ao tentar inserir: Nome já existe", exception.getMessage());
//
//        //cargo.setNovo(false);
//        cargo.setId(1L);
//        when(cargoRepository.existsByNomeAndIdNot(cargo.getNome(), cargo.getId())).thenReturn(true);
//        exception = assertThrows(DrTransferException.class, () -> cargoService.validaEntidade(cargo));
//        assertEquals(HttpStatus.CONFLICT, exception.getStatus());
//        assertEquals("Conflito ao tentar inserir: Nome já existe", exception.getMessage());
//    }

    @Test
    void testAtualizaVinculos() {
        assertDoesNotThrow(() -> cargoService.atualizaVinculos(cargo));
    }

    @Test
    void testAtualizarEntidade() throws DrTransferException {
        Cargo cargoPersistido = new Cargo();
        cargoPersistido.setNome("Assistente");
        cargoPersistido.setAtivo(false);

        cargo.setNome("Gerente");
        cargo.setAtivo(true);

        cargoService.atualizarEntidade(cargoPersistido, cargo);

        assertEquals("Gerente", cargoPersistido.getNome());
        assertTrue(cargoPersistido.getAtivo());
    }
}

