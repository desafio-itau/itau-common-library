package com.itau.common.library.exception;

import com.itau.common.library.constants.Constants;

public class NegocioException extends BaseException {

    public NegocioException(Constants errorConstant) {
        super(errorConstant);
    }

    public NegocioException(Constants errorConstant, Throwable cause) {
        super(errorConstant, cause);
    }
}

