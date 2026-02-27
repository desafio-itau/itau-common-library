package com.itau.common.library.exception;

import com.itau.common.library.constants.Constants;

public class RecursoNaoEncontradoException extends BaseException {

    public RecursoNaoEncontradoException(Constants errorConstant) {
        super(errorConstant);
    }

    public RecursoNaoEncontradoException(Constants errorConstant, Throwable cause) {
        super(errorConstant, cause);
    }
}

