package br.ufg.inf.backend.drtransfer.controller;

import br.ufg.inf.backend.drtransfer.exception.DrTransferException;
import br.ufg.inf.backend.drtransfer.model.Cargo;
import br.ufg.inf.backend.drtransfer.service.CargoService;
import br.ufg.inf.backend.drtransfer.utils.GenericController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestController
@RequestMapping("/cargo")
public class CargoController extends GenericController<Cargo, CargoService> {
}
