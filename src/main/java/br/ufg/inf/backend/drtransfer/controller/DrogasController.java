package br.ufg.inf.backend.drtransfer.controller;

import br.ufg.inf.backend.drtransfer.model.Drogas;
import br.ufg.inf.backend.drtransfer.service.DrogasService;
import br.ufg.inf.backend.drtransfer.utils.GenericControllerWithDeletion;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/drogas")
public class DrogasController extends GenericControllerWithDeletion<Drogas, DrogasService> {

}
