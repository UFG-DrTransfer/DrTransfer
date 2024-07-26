package br.ufg.inf.backend.drtransfer.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class DrTransferException extends Exception {

    private HttpStatus status;

//    public DrTransferException(String message, Object... args) {
//        this(HttpStatus.BAD_REQUEST, message, args);
//    }

    public DrTransferException(HttpStatus status, String message, Object... args) {
        super(String.format(message, args));
        this.status = status;
    }

}
