package br.ufg.inf.backend.drtransfer.controller;


import br.ufg.inf.backend.drtransfer.model.Transferencia;
import br.ufg.inf.backend.drtransfer.service.TransferenciaService;
import br.ufg.inf.backend.drtransfer.utils.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transferencia")
public class TransferenciaController extends GenericController<Transferencia, TransferenciaService> {


}
