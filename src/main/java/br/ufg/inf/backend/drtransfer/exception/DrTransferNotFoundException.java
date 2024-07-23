package br.ufg.inf.backend.drtransfer.exception;

public class DrTransferNotFoundException extends DrTransferException {

    public DrTransferNotFoundException(String message, Object... args) {
        super(message, args);
    }

    public DrTransferNotFoundException(String message) {
        super(message);
    }
    
}
