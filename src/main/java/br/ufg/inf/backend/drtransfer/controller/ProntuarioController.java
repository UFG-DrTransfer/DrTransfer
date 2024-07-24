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
//POST http://localhost:8080/prontuario
//{
//    "classificacao": "PRIMARIA",
//    "medicamentoPrescrito" : [
//        {
//        "posologia" : "MEDICAMENTO1",
//        "dosagem": 10.0,
//        "viaAdministracao": "ORAL",
//        "unidadeDosagem": "ML"
//        },
//        {
//        "posologia" : "VAI TOMAR MEDICAMENTO2",
//        "dosagem": 10.0,
//        "viaAdministracao": "ORAL",
//        "unidadeDosagem": "ML"
//        },
//        {
//        "posologia" : "VAI TOMAR MEDICAMENTO3",
//        "dosagem": 10.0,
//        "viaAdministracao": "ORAL",
//        "unidadeDosagem": "ML"
//        },
//        {
//        "posologia" : "VAI TOMAR MEDICAMENTO4",
//        "dosagem": 10.0,
//        "viaAdministracao": "ORAL",
//        "unidadeDosagem": "ML"
//        }
//    ]
//}