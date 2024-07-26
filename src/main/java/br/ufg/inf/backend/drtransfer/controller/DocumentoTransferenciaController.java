package br.ufg.inf.backend.drtransfer.controller;


import br.ufg.inf.backend.drtransfer.model.DocumentoTransferencia;
import br.ufg.inf.backend.drtransfer.service.DocumentoTransferenciaService;
import br.ufg.inf.backend.drtransfer.utils.GenericController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/documentotransferencia")
@RestController
public class DocumentoTransferenciaController extends GenericController<DocumentoTransferencia, DocumentoTransferenciaService> {

}











