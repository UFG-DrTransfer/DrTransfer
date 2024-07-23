package br.ufg.inf.backend.drtransfer.utils;

import br.ufg.inf.backend.drtransfer.exception.DrTransferException;
import br.ufg.inf.backend.drtransfer.exception.DrTransferNotFoundException;
import br.ufg.inf.backend.drtransfer.model.Hospital;
import br.ufg.inf.backend.drtransfer.model.abstracts.SuperClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")

public abstract class GenericService<E extends SuperClass, R extends JpaRepository<E, Long>> {

    public static final String FALHA_BD = "Falha ao %s %s, tente novamente. Se o problema persistir contacte o suporte";

    @Autowired
    protected R repository;
    private String nomeClasse;

    //Dar nome as classes para o retorno das mensagens.
    public GenericService(String nomeClasse) {
        this.nomeClasse = nomeClasse;
    }

    public List<E> findAll() {
        return repository.findAll();
    }

    public E findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new DrTransferNotFoundException("%s com ID %d não encontrado", nomeClasse, id));

//        Optional<E> optional = repository.findById(id);
//        if (optional.isPresent()) {
//            return optional.get();
//        } else {
//            throw new DrTransferNotFoundException("%s com ID %d não encontrado", nomeClasse, id);
//        }
    }

    /**
     *     Retorna o objeto hospital para o hospitalValidado.
     */
    public E findByEntidade(E entidade) {
        if (entidade != null) {
            if (entidade.getId() == null)
                throw new DrTransferException("É necessário informar o ID de %s", nomeClasse);
            return findById(entidade.getId());
        }
        return null;
    }

    public E save(E entidade) {
        try {
            validaEntidade(entidade);
            return repository.save(entidade);
        } catch (Exception e) {
            throw new DrTransferException(FALHA_BD, "salvar", nomeClasse);
        }
    }

    public E update(E entidade) {
        validaNulo(entidade);
        validaEntidade(entidade);
        return update(entidade.getId(), entidade);
    }

    public E update(Long id, E entidade) {
        try {
            E entidadePersistida = findById(id);
            atualizarEntidade(entidadePersistida, entidade);
            return update(entidade);
        } catch (Exception e) {
            throw new DrTransferException(FALHA_BD, "atualizar", nomeClasse);
        }
    }

    /**
     * Essa função vai definir os set nos atributos que serão atualizados dessa entidade.
     *
     * @param entidadePersistida entidade que foi recuperada do banco
     * @param entidadeAtualizada entidade que contem os novos dados a serem SETADOS
     */
    protected abstract void atualizarEntidade(E entidadePersistida, E entidadeAtualizada);

    public void deleteById(Long id) {
        try {
            findById(id);
            repository.deleteById(id);
        } catch (Exception e) {
            throw new DrTransferException(FALHA_BD, "deletar", nomeClasse);
        }
    }

    private void validaNulo(E entidade) {
        if (entidade == null) {
            throw new DrTransferException("%s com não foi informado.", nomeClasse);
        }
    }

    public static boolean validaString(String textoEntrada) {
        return textoEntrada != null && !textoEntrada.isBlank();
    }

    protected abstract void validaEntidade(E entidade);

}

