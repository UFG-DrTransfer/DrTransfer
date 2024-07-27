package br.ufg.inf.backend.drtransfer.utils;

import br.ufg.inf.backend.drtransfer.exception.DrTransferException;
import br.ufg.inf.backend.drtransfer.model.abstracts.SuperClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.List;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service
public abstract class GenericService<E extends SuperClass, R extends JpaRepository<E, Long>> {

    @Autowired
    protected R repository;
    protected final String nomeClasse;

    public static final String CAMPO_OBRIGATORIO = "%s contém o campo %s que é obrigatório.";
    public static final String CONFLICT = "%s já existe um cadastro com este %s";
    public static final String FALHA_BD = "Falha desconhecida. Contacte o suporte.";
    public static final String ID_INVALIDO = "É necessário passar o identificador do(a) %s";


    //Dar nome as classes para o retorno das mensagens.
    public GenericService(String nomeClasse) {
        this.nomeClasse = nomeClasse;
    }

    public List<E> findAll() {
        return repository.findAll();
    }

    public E findById(Long id) throws DrTransferException {
        return repository.findById(id)
                .orElseThrow(() -> new DrTransferException(HttpStatus.NOT_FOUND, "%s com ID %d não encontrado", nomeClasse, id));
//        Optional<E> optional = repository.findById(id);
//        if (optional.isPresent()) {
//            return optional.get();
//        } else {
//            throw new DrTransferNotFoundException("%s com ID %d não encontrado", nomeClasse, id);
//        }
    }

    /**
     * Retorna o objeto hospital para o hospitalValidado.
     */
    public E findByEntidade(E entidade) throws DrTransferException {
        if (entidade != null) {
            campoObrigatorio(entidade.getId(), "ID");
            return findById(entidade.getId());
        }
        return null;
    }

    public E save(E entidade) throws DrTransferException {
        padronizaCampos(entidade);
        validaEntidade(entidade);
        atualizaVinculos(entidade);
        try {
            return repository.save(entidade);
        } catch (Exception e) {
            throw new DrTransferException(HttpStatus.UNPROCESSABLE_ENTITY, FALHA_BD, "salvar", nomeClasse);
        }
    }

    public E update(E entidade) throws DrTransferException {
        validaNulo(entidade);
        return update(entidade.getId(), entidade);
    }

    public E update(Long id, E entidade) throws DrTransferException {
        entidade.setId(id);
        E entidadePersistida = findById(id);
        padronizaCampos(entidade);
        validaEntidade(entidade);
        atualizaVinculos(entidade);
        atualizarEntidade(entidadePersistida, entidade);
        try {
            return repository.save(entidadePersistida);
        } catch (Exception e) {
            throw new DrTransferException(HttpStatus.UNPROCESSABLE_ENTITY, FALHA_BD, "atualizar", nomeClasse);
        }
    }

    public void deleteById(Long id) throws DrTransferException {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new DrTransferException(HttpStatus.CONFLICT, FALHA_BD, "deletar", nomeClasse);
        }
    }

    protected void validaNulo(E entidade) throws DrTransferException {
        if (entidade == null) {
            throw new DrTransferException(HttpStatus.BAD_REQUEST, "%s com não foi informado.", nomeClasse);
        }
    }

    /**
     * Valida se o objeto passado é nulo, caso nulo ele retorna mensagem de campo obrigatório
     *
     * @param objetoValidacao
     * @param nomeCampo
     * @throws DrTransferException
     */
    protected void campoObrigatorio(Object objetoValidacao, String nomeCampo) throws DrTransferException {
        if (objetoValidacao == null || (objetoValidacao instanceof String && ((String) objetoValidacao).isBlank())) {
            throw new DrTransferException(HttpStatus.BAD_REQUEST, CAMPO_OBRIGATORIO, nomeClasse, nomeCampo);
        }
    }

    /**
     * Método tem como função de padronizar os dados do campo. Por exemplo: removendo espaço duplo,
     * deixar todos campos em caixa alta, atualizar senha para uma criptografia, etc.
     *
     * @param entidade
     */
    protected abstract void padronizaCampos(E entidade) throws DrTransferException;

    /**
     * Valida todos campos que são obrigatórios para a entidade poder ser criada
     *
     * @param entidade
     */
    protected abstract void validaEntidade(E entidade) throws DrTransferException;

    /**
     * Este método tem como objetivo de atualizar vinculos da classe atual com outras classes, caso exista id ele busca
     * o vinculo caso não exista ele valida os dados para poder criar.
     *
     * @param entidade
     */
    protected abstract void atualizaVinculos(E entidade) throws DrTransferException;

    /**
     * Esse método vai definir os set nos atributos que serão atualizados dessa entidade.
     *
     * @param entidadePersistida entidade que foi recuperada do banco
     * @param entidadeAtualizada entidade que contem os novos dados a serem SETADOS
     */
    protected abstract void atualizarEntidade(E entidadePersistida, E entidadeAtualizada) throws DrTransferException;

    /**
     * Método tem como objetivo de validar se um campo existe, .
     *
     * @param objeto a ser validado
     * @return true caso objeto não seja nulo e para caso o objeto for string não esteja em branco. E false para o contrário.
     */
    public static boolean validaExistente(Object objeto) {
        return objeto != null && !(objeto instanceof String && ((String) objeto).isBlank());
    }

    /**
     * Método que tem como objetivo de atualizar um campo especifico
     *
     * @param entidadePersistida entidade que foi buscada do banco de dados
     * @param entidadeAtualizada entidade com os novos dados que precisa atualizar na entidadePersistida
     * @param nomeAtributo       nome do campo que será atualizado
     * @param <T>                o tipo da classe da entidade.
     */
    public static <T> void atualizaCampo(T entidadePersistida, T entidadeAtualizada, String nomeAtributo) throws DrTransferException {
        try {
            // Obter o método getter para o campo especificado na entidadeAtualizada
            Method getter = entidadeAtualizada.getClass().getMethod("get" + capitalize(nomeAtributo));
            // Invocar o método getter para obter o valor atualizado
            Object valorAtualizado = getter.invoke(entidadeAtualizada);

            // Verificar se o valor atualizado não é nulo e, no caso de strings, não é vazio
            if (validaExistente(valorAtualizado)) {
                // Obter o método setter correspondente na entidadePersistida
                Method setter = entidadePersistida.getClass().getMethod("set" + capitalize(nomeAtributo), getter.getReturnType());
                // Invocar o método setter para atualizar o campo na entidadePersistida
                setter.invoke(entidadePersistida, valorAtualizado);
            }
        } catch (Exception e) {
            throw new DrTransferException(HttpStatus.BAD_REQUEST, "Falha ao atualizar campo %s, não foi encontrado o método get%s e set%s entre em contato com suporte.", nomeAtributo, capitalize(nomeAtributo), capitalize(nomeAtributo));
        }
    }

    /**
     * Método utilitário para capitalizar a primeira letra de uma string, ou seja, pega a primeira letra e coloca em upperCase
     *
     * @param str
     * @return
     */
    private static String capitalize(String str) throws DrTransferException {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}

