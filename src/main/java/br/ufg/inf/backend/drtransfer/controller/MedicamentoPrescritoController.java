package br.ufg.inf.backend.drtransfer.controller;

import br.ufg.inf.backend.drtransfer.model.MedicamentoPrescrito;
import br.ufg.inf.backend.drtransfer.service.MedicamentoPrescritoService;
import br.ufg.inf.backend.drtransfer.utils.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicamentoprescrito")
public class MedicamentoPrescritoController extends GenericController<MedicamentoPrescrito, MedicamentoPrescritoService> {
}
