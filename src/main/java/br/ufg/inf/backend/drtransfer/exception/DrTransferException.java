package br.ufg.inf.backend.drtransfer.exception;

public class DrTransferException extends Exception {

    public DrTransferException(String message) {
        super(message);
    }

    public DrTransferException(String message, Object...args) {
        super(String.format(message,args));
    }
}
