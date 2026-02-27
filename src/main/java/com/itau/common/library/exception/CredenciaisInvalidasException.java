package com.itau.common.library.exception;

import com.itau.common.library.constants.Constants;

public class CredenciaisInvalidasException extends BaseException {
    public CredenciaisInvalidasException(Constants errorConstant) {
        super(errorConstant);
    }

    public CredenciaisInvalidasException(Constants errorConstant, Throwable cause) {
        super(errorConstant, cause);
    }
}
