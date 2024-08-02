package br.ufg.inf.backend.drtransfer.controller;

import br.ufg.inf.backend.drtransfer.model.Funcionario;
import br.ufg.inf.backend.drtransfer.service.FuncionarioService;
import br.ufg.inf.backend.drtransfer.utils.GenericControllerWithDeletion;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController extends GenericControllerWithDeletion<Funcionario, FuncionarioService> {
}
