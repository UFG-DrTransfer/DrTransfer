package br.ufg.inf.backend.drtransfer.controller;


import br.ufg.inf.backend.drtransfer.model.Hospital;
import br.ufg.inf.backend.drtransfer.service.HospitalService;
import br.ufg.inf.backend.drtransfer.utils.GenericControllerWithDeletion;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/hospital")
public class HospitalController extends GenericControllerWithDeletion<Hospital, HospitalService> {
}
