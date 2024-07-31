package br.ufg.inf.backend.drtransfer.usuario;

import br.ufg.inf.backend.drtransfer.exception.DrTransferException;
import br.ufg.inf.backend.drtransfer.model.Usuario;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTeste {

    @InjectMocks
    private UsuarioServiceTesteHelper usuarioService;

    private Usuario usuario;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        usuario = new Usuario();
        usuario.setLogin("testUser");
        usuario.setSenha("testPassword");
    }

    @Test
    void testPadronizaCampos() {
        usuarioService.padronizaCampos(usuario);
        assertNotNull(usuario.getSenha());
        assertTrue(usuario.getSenha().endsWith("criptografado"));
    }

//    @Test
//    void testValidaEntidade() {
//        usuario.setSenha("1234567");
//        assertDoesNotThrow(() -> usuarioService.validaEntidade(usuario));
//
//        usuario.setSenha("12345");
//        DrTransferException exception = assertThrows(DrTransferException.class, () -> usuarioService.validaEntidade(usuario));
//        assertEquals(HttpStatus.BAD_REQUEST, exception.getStatus());
//        assertEquals("Senha deve ter no mínimo 6 caracteres", exception.getMessage());
//    }

    @Test
    void testAtualizarEntidade() throws DrTransferException {
        Usuario usuarioPersistido = new Usuario();
        usuarioPersistido.setLogin("persistedUser");
        usuarioPersistido.setSenha("persistedPassword");

        usuarioService.atualizarEntidade(usuarioPersistido, usuario);

        assertEquals("testUser", usuarioPersistido.getLogin());
        assertEquals("testPassword", usuarioPersistido.getSenha());
    }
}
