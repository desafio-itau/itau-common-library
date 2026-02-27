package com.itau.common.library.exception;

public class NegocioException extends RuntimeException {

    public NegocioException(String errorCode) {
        super(errorCode);
    }
}

