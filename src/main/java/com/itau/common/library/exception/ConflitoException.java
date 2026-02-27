package com.itau.common.library.exception;

public class ConflitoException extends RuntimeException {
    public ConflitoException(String errorCode) {
        super(errorCode);
    }
}
