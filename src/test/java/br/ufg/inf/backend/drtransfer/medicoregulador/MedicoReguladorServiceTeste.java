package br.ufg.inf.backend.drtransfer.medicoregulador;

import br.ufg.inf.backend.drtransfer.exception.DrTransferException;
import br.ufg.inf.backend.drtransfer.model.MedicoRegulador;
import br.ufg.inf.backend.drtransfer.repository.MedicoReguladorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MedicoReguladorServiceTeste {

    @Mock
    private MedicoReguladorRepository medicoReguladorRepository;

    @InjectMocks
    private MedicoReguladorServiceTesteHelper medicoReguladorService;

    private MedicoRegulador medicoRegulador;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        medicoRegulador = new MedicoRegulador();
        medicoRegulador.setNome("Ana Maria");
        medicoRegulador.setCrm("12345");
    }

    @Test
    void testPadronizaCampos() throws DrTransferException {
        medicoReguladorService.padronizaCampos(medicoRegulador);
        assertEquals("ANA MARIA", medicoRegulador.getNome());
        assertEquals("12345", medicoRegulador.getCrm());
    }

//    @Test
//    void testValidaEntidade() {
//        assertDoesNotThrow(() -> medicoReguladorService.validaEntidade(medicoRegulador));
//
//        medicoRegulador.setCrm(null);
//        DrTransferException exception = assertThrows(DrTransferException.class, () -> medicoReguladorService.validaEntidade(medicoRegulador));
//        assertEquals("Campo obrigatório não preenchido: CRM", exception.getMessage());
//    }

    @Test
    void testAtualizaVinculos() {
        // Como o método atualizaVinculos está vazio, não há ações a testar aqui.
        assertDoesNotThrow(() -> medicoReguladorService.atualizaVinculos(medicoRegulador));
    }

    @Test
    void testAtualizarEntidade() throws DrTransferException {
        MedicoRegulador medicoReguladorPersistido = new MedicoRegulador();
        medicoReguladorPersistido.setNome("João Souza");
        medicoReguladorPersistido.setEmail("joao@example.com");

        medicoRegulador.setNome("Ana Maria");
        medicoRegulador.setEmail("ana@example.com");

        medicoReguladorService.atualizarEntidade(medicoReguladorPersistido, medicoRegulador);

        assertEquals("Ana Maria", medicoReguladorPersistido.getNome());
        assertEquals("ana@example.com", medicoReguladorPersistido.getEmail());
    }
}

