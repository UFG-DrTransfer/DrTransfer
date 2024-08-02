package br.ufg.inf.backend.drtransfer.controller;

import br.ufg.inf.backend.drtransfer.model.Usuario;
import br.ufg.inf.backend.drtransfer.service.UsuarioService;
import br.ufg.inf.backend.drtransfer.utils.GenericControllerWithDeletion;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController extends GenericControllerWithDeletion<Usuario, UsuarioService> {

}
