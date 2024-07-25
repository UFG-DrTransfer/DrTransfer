package br.ufg.inf.backend.drtransfer.utils.formatador;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatadorUtils {

    public static String formataData(String data) {
        return new SimpleDateFormat("dd 'de' MMMM 'de' yyyy").format(new Date(data));
    }
}
