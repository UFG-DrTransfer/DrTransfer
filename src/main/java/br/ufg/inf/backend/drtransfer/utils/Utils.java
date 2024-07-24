package br.ufg.inf.backend.drtransfer.utils;

import br.ufg.inf.backend.drtransfer.exception.DrTransferException;

import java.lang.reflect.Field;
import java.text.Normalizer;
import java.util.regex.Pattern;

public abstract class Utils {
    /**
     * Método para remover acentos de uma string
     *
     * @param str
     * @return
     */
    public static String removerAcentos(String str) {
        String normalized = Normalizer.normalize(str, Normalizer.Form.NFD);
        return normalized.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
    }

    /**
     * Método para validar um endereço de email
     *
     * @param email
     * @return
     */
    public static boolean validarEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    /**
     * Método para remover espaços duplos e aplicar trim()
     *
     * @param str
     * @return
     */
    public static String removerEspacosDuplos(String str) {
        if (str == null) {
            return null;
        }
        return str.trim().replaceAll("\\s+", " ");
    }

    /**
     * Passa a entidade e o nome do atributo que seja string e atualiza ele para caixa alta, com trim() e sem espaço duplo.
     *
     * @param entidade
     * @param nomeAtributo
     * @param <T>
     * @return
     * @throws DrTransferException
     */
    public static <T> T maiuscula(T entidade, String nomeAtributo) throws DrTransferException {
        try {
            Field campo = entidade.getClass().getDeclaredField(nomeAtributo);
            campo.setAccessible(true);
            Object valor = campo.get(entidade);
            if (valor instanceof String) {
                campo.set(entidade, removerEspacosDuplos((String) valor).toUpperCase());
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new DrTransferException("Erro ao tentar atualizar campo %s para maiuscula", nomeAtributo);
        }
        return entidade;
    }

}
