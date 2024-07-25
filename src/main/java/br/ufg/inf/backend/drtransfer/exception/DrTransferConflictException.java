package br.ufg.inf.backend.drtransfer.exception;

public class DrTransferConflictException extends DrTransferException {
    public DrTransferConflictException(String message, Object... args) {

        super(message, args);
    }

    public DrTransferConflictException(String message) {

        super(message);
    }

}
