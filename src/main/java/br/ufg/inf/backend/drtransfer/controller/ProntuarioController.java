package br.ufg.inf.backend.drtransfer.controller;

import br.ufg.inf.backend.drtransfer.model.Prontuario;
import br.ufg.inf.backend.drtransfer.service.ProntuarioService;
import br.ufg.inf.backend.drtransfer.utils.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prontuario")
public class ProntuarioController extends GenericController<Prontuario, ProntuarioService> {
}
