package com.itau.common.library.exception;

public class RecursoNaoEncontradoException extends RuntimeException {

    public RecursoNaoEncontradoException(String errorCode) {
        super(errorCode);
    }
}

