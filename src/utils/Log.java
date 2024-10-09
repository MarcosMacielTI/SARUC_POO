package utils;

import java.util.Date;

public class Log {
    public static void registrar(String acao) {
        Date agora = new Date();
        System.out.println("LOG [" + agora + "]: " + acao);
    }
}
