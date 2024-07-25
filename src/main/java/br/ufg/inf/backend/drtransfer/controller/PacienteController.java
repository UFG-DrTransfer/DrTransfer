package br.ufg.inf.backend.drtransfer.controller;

import br.ufg.inf.backend.drtransfer.model.Paciente;
import br.ufg.inf.backend.drtransfer.repository.PacienteRepository;
import br.ufg.inf.backend.drtransfer.service.PacienteService;
import br.ufg.inf.backend.drtransfer.utils.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paciente")
public class PacienteController extends GenericController<Paciente, PacienteService> {
}
