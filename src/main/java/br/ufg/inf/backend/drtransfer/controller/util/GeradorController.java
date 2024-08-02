package br.ufg.inf.backend.drtransfer.controller.util;


import br.ufg.inf.backend.drtransfer.enumeradores.Sexo;
import br.ufg.inf.backend.drtransfer.enumeradores.TipoSanguineo;
import br.ufg.inf.backend.drtransfer.exception.DrTransferException;
import br.ufg.inf.backend.drtransfer.model.*;
import br.ufg.inf.backend.drtransfer.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;


@RestController
@RequestMapping("/gerardados")
public class GeradorController {

    @Autowired
    private CargoService cargoService;

    @Autowired
    private EspecialidadeService especialidadeService;

    @Autowired
    private HospitalService hospitalService;

    @Autowired
    private MedicoService medicoService;

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private SolicitacaoService solicitacaoService;

    @GetMapping
    public ResponseEntity<?> setData() throws DrTransferException {
        //Cargo cargo = new Cargo("Medico");
        Cargo cargo = Cargo.builder().nome("Professor1").build();
        cargoService.save(cargo);

//        Cargo cargo = cargoService.findById(1L);
//        Especialidade especialidade = especialidadeService.findById(1L);

        Especialidade especialidade = new Especialidade("Cardiologia", "Cuidado do coracao");
        especialidadeService.save(especialidade);

        Hospital hospital = new Hospital("Santa Casa", "111111111", "hospital@hgg.com", -16.689023095791725, -49.28920555578136, 10, true, new ArrayList<>());
        hospitalService.save(hospital);
        Hospital hospital2 = new Hospital("Hugol", "22222222", "hospital@hugol.com", -16.646997523824627, -49.33789408889512, 20, true, new ArrayList<>());
        hospitalService.save(hospital2);


        Medico medico = new Medico("Alexsandro", "999.999.999-99", "62 9999-9999", "alexsandro@hogwarts.medic", Sexo.MASCULINO, cargo, hospital, "15616GO", especialidade);
        medicoService.save(medico);

        Medico medico2 = Medico.builder().nome("MedicoBuilder").cpf("8888888").crm("999999").hospital(hospital).especialidade(especialidade).build();
        medicoService.save(medico2);

        Paciente paciente = new Paciente("Jonh", "999.999.999-99", "62 9999-9999", "john@hogwarts.medic", Sexo.MASCULINO, LocalDate.of(1977, 7, 2), TipoSanguineo.B_NEGATIVO);
        pacienteService.save(paciente);

        DocumentoTransferencia documentoTransferencia = DocumentoTransferencia.builder().documento("documento1").observacao("observando").build();
        Solicitacao solicitacao = Solicitacao.builder().documento(documentoTransferencia).medico(medico).especialidade(especialidade).paciente(paciente).build();
        solicitacaoService.save(solicitacao);


        return ResponseEntity.ok().build();
    }
}