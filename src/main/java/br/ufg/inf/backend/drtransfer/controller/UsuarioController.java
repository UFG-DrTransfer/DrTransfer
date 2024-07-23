package br.ufg.inf.backend.drtransfer.controller;

import br.ufg.inf.backend.drtransfer.model.Usuario;
import br.ufg.inf.backend.drtransfer.service.UsuarioService;
import br.ufg.inf.backend.drtransfer.utils.GenericController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.AbstractController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController extends GenericController<Usuario, UsuarioService> {

}
