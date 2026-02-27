package com.itau.common.library.exception;

import com.itau.common.library.constants.Constants;
import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {

    private final Constants errorConstant;

    public BaseException(Constants errorConstant) {
        super(errorConstant.getMensagem());
        this.errorConstant = errorConstant;
    }

    public BaseException(Constants errorConstant, Throwable cause) {
        super(errorConstant.getMensagem(), cause);
        this.errorConstant = errorConstant;
    }
}

