package br.ufg.inf.backend.drtransfer.controller;

import br.ufg.inf.backend.drtransfer.model.MedicoRegulador;
import br.ufg.inf.backend.drtransfer.service.MedicoReguladorService;
import br.ufg.inf.backend.drtransfer.utils.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicoregulador")
public class MedicoReguladorController extends GenericController<MedicoRegulador, MedicoReguladorService> {
}
