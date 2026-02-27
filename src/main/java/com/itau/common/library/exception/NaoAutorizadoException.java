package com.itau.common.library.exception;

public class NaoAutorizadoException extends RuntimeException {

    public NaoAutorizadoException(String message) {
        super(message);
    }

    public NaoAutorizadoException(String message, Throwable cause) {
        super(message, cause);
    }
}

