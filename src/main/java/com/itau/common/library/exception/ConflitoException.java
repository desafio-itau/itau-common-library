package com.itau.common.library.exception;

import com.itau.common.library.constants.Constants;

public class ConflitoException extends BaseException {
    public ConflitoException(Constants errorConstant) {
        super(errorConstant);
    }

    public ConflitoException(Constants errorConstant, Throwable cause) {
        super(errorConstant, cause);
    }
}
