package br.ufg.inf.backend.drtransfer.droga;

import br.ufg.inf.backend.drtransfer.exception.DrTransferException;
import br.ufg.inf.backend.drtransfer.model.Drogas;
import br.ufg.inf.backend.drtransfer.repository.DrogasRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
public class DrogaServiceTeste {

    @Mock
    private DrogasRepository drogasRepository;

    @InjectMocks
    private DrogaServiceTesteHelper drogasService;

    private Drogas drogas;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        drogas = new Drogas();
        drogas.setNome("Paracetamol");
        drogas.setPrincipioAtivo("Acetaminofeno");
    }

    @Test
    void testPadronizaCampos() throws DrTransferException {
        drogasService.padronizaCampos(drogas);
        assertEquals("PARACETAMOL", drogas.getNome());
    }

//    @Test
//    void testValidaEntidade() {
//        when(drogasRepository.existsByNome(drogas.getNome())).thenReturn(false);
//        assertDoesNotThrow(() -> drogasService.validaEntidade(drogas));
//
//        drogas.setNome(null);
//        DrTransferException exception = assertThrows(DrTransferException.class, () -> drogasService.validaEntidade(drogas));
//        assertEquals("Campo obrigatório não preenchido: Nome", exception.getMessage());
//
//        drogas.setNome("Paracetamol");
//        drogas.setNovo(true);
//        when(drogasRepository.existsByNome(drogas.getNome())).thenReturn(true);
//        exception = assertThrows(DrTransferException.class, () -> drogasService.validaEntidade(drogas));
//        assertEquals(HttpStatus.CONFLICT, exception.getStatus());
//        assertEquals("Conflito ao tentar inserir: Nome já existe", exception.getMessage());
//
//        drogas.setNovo(false);
//        drogas.setId(1L);
//        when(drogasRepository.existsByNomeAndIdNot(drogas.getNome(), drogas.getId())).thenReturn(true);
//        exception = assertThrows(DrTransferException.class, () -> drogasService.validaEntidade(drogas));
//        assertEquals(HttpStatus.CONFLICT, exception.getStatus());
//        assertEquals("Conflito ao tentar inserir: Nome já existe", exception.getMessage());
//    }

    @Test
    void testAtualizaVinculos() {
        assertDoesNotThrow(() -> drogasService.atualizaVinculos(drogas));
    }

    @Test
    void testAtualizarEntidade() throws DrTransferException {
        Drogas drogasPersistidas = new Drogas();
        drogasPersistidas.setNome("Ibuprofeno");
        drogasPersistidas.setPrincipioAtivo("Ibuprofeno");

        drogas.setNome("Paracetamol");
        drogas.setPrincipioAtivo("Acetaminofeno");

        drogasService.atualizarEntidade(drogasPersistidas, drogas);

        assertEquals("Paracetamol", drogasPersistidas.getNome());
        assertEquals("Acetaminofeno", drogasPersistidas.getPrincipioAtivo());
    }
}

