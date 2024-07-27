package br.ufg.inf.backend.drtransfer.controller;


import br.ufg.inf.backend.drtransfer.exception.DrTransferException;
import br.ufg.inf.backend.drtransfer.model.Hospital;
import br.ufg.inf.backend.drtransfer.service.HospitalService;
import br.ufg.inf.backend.drtransfer.utils.GenericController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/hospital")
public class HospitalController extends GenericController<Hospital, HospitalService> {
}
