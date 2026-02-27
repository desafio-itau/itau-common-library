package com.itau.common.library.exception;

public class ServicoIndisponivelException extends RuntimeException {
    public ServicoIndisponivelException(String errorCode) {
        super(errorCode);
    }
}
