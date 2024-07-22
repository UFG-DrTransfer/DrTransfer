package br.ufg.inf.backend.drtransfer.service;

import br.ufg.inf.backend.drtransfer.model.Medico;
import br.ufg.inf.backend.drtransfer.model.abstracts.SuperClass;
import br.ufg.inf.backend.drtransfer.utils.GenericService;

public class MedicoService extends GenericService<Medico, MedicoRepository> {


    public MedicoService() {
        super("Médico");
    }

    @Override
    protected void atualizarEntidade(Medico entidadePersistida, Medico entidadeAtualizada) {
        entidadePersistida.setNome(entidadeAtualizada.getNome());
        entidadePersistida.setEmail(entidadeAtualizada.getEmail());
        entidadePersistida.setTelefone(entidadeAtualizada.getTelefone());
        entidadePersistida.setCpf(entidadeAtualizada.getCpf());
        entidadePersistida.setSexo(entidadeAtualizada.getSexo());
        entidadePersistida.setCrm(entidadeAtualizada.getCrm());
        entidadePersistida.setAtivo(entidadeAtualizada.isAtivo());


        entidadePersistida.setHospital(entidadeAtualizada.getHospital());

    }
}
