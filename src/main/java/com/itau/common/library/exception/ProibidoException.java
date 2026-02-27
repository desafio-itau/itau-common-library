package com.itau.common.library.exception;

public class ProibidoException extends RuntimeException {

    public ProibidoException(String message) {
        super(message);
    }

    public ProibidoException(String message, Throwable cause) {
        super(message, cause);
    }
}

