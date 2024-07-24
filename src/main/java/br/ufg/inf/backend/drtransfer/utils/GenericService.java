package br.ufg.inf.backend.drtransfer.utils;

import br.ufg.inf.backend.drtransfer.exception.DrTransferException;
import br.ufg.inf.backend.drtransfer.exception.DrTransferNotFoundException;
import br.ufg.inf.backend.drtransfer.model.abstracts.SuperClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.Method;
import java.util.List;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public abstract class GenericService<E extends SuperClass, R extends JpaRepository<E, Long>> {

    @Autowired
    protected R repository;
    protected final String nomeClasse;

    public static final String CAMPO_OBRIGATORIO = "%s contém o campo %s que é obrigatório.";
    public static final String CONFLICT = "%s já existe um cadastro com este %s";
    public static final String FALHA_BD = "Falha desconhecida. Contacte o suporte.";


    //Dar nome as classes para o retorno das mensagens.
    public GenericService(String nomeClasse) {
        this.nomeClasse = nomeClasse;
    }

    public List<E> findAll() {
        return repository.findAll();
    }

    public E findById(Long id) throws DrTransferNotFoundException {
        return repository.findById(id).orElseThrow(() -> new DrTransferNotFoundException("%s com ID %d não encontrado", nomeClasse, id));
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
            throw new DrTransferException(FALHA_BD, "salvar", nomeClasse);
        }
    }

    public E update(E entidade) throws DrTransferException {
        validaNulo(entidade);
        return update(entidade.getId(), entidade);
    }

    public E update(Long id, E entidade) throws DrTransferException {
        E entidadePersistida = findById(id);
        padronizaCampos(entidadePersistida);
        validaEntidade(entidade);
        atualizaVinculos(entidade);
        atualizarEntidade(entidadePersistida, entidade);
        try {
            return repository.save(entidadePersistida);
        } catch (Exception e) {
            throw new DrTransferException(FALHA_BD, "atualizar", nomeClasse);
        }
    }

    public void deleteById(Long id) throws DrTransferException {
        try {
            findById(id);
            repository.deleteById(id);
        } catch (Exception e) {
            throw new DrTransferException(FALHA_BD, "deletar", nomeClasse);
        }
    }

    protected void validaNulo(E entidade) throws DrTransferException {
        if (entidade == null) {
            throw new DrTransferException("%s com não foi informado.", nomeClasse);
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
        if (objetoValidacao == null) {
            throw new DrTransferException(CAMPO_OBRIGATORIO, nomeClasse, nomeCampo);
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


//    /**
//     * Método tem como objetivo de validar se um campo está preenchida, ou seja, não nulo e ter conteudo.
//     *
//     * @param textoEntrada texto a ser validado
//     * @return true para caso estiver conteudo e false caso contrário.
//     */
//    public static boolean validaString(String textoEntrada) {
//        return textoEntrada != null && !textoEntrada.isBlank();
//    }

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
            throw new DrTransferException("Falha ao atualizar campo %s, entre em contato com suporte.", nomeAtributo);
        }
    }

    /**
     * Método utilitário para capitalizar a primeira letra de uma string, ou seja, pega a primeira letra e coloca em upperCase
     *
     * @param str
     * @return
     */
    private static String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}

