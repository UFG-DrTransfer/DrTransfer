package br.ufg.inf.backend.drtransfer.service;

import br.ufg.inf.backend.drtransfer.exception.DrTransferException;
import br.ufg.inf.backend.drtransfer.model.Hospital;
import br.ufg.inf.backend.drtransfer.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalService {

	@Autowired
	private HospitalRepository repository;

	public List<Hospital> findAll() {
		return repository.findAll();
	}

	public Hospital findByName(String nome) {
		Optional<Hospital> hospital = repository.findByNome(nome);
		if (hospital.isPresent()) {
			return hospital.get();
		}else {
			throw new DrTransferException("Hospital com nome: " + nome + " não encontrado.");
		}
	}

	public Hospital save(Hospital hospital) {
		try {
			return repository.save(hospital);
		} catch (Exception e) {
			throw new DrTransferException("Falha ao salvar no BD");
		}
	}

	public Hospital update(Hospital hospital) {
		Optional<Hospital> existingHospital = repository.findById(hospital.getId());
		if (existingHospital.isPresent()) {
			return save(hospital);
		} else {
			throw new DrTransferException("Hospital com ID %d não encontrado", hospital.getId());
		}
	}

	public void deleteById(Long id) {
		Optional<Hospital> existingHospital = repository.findById(id);
		if (existingHospital.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new DrTransferException("Hospital com ID %d não encontrado", id);
		}
	}

}
